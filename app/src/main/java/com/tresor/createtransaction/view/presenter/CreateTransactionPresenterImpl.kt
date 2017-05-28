package com.tresor.createtransaction.view.presenter

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.tresor.base.data.AndroidPostExecutionThread
import com.tresor.base.data.JobExecutor
import com.tresor.base.domain.ThreadExecutor
import com.tresor.base.view.BaseObserver
import com.tresor.createtransaction.view.activity.CreateTransactionActivity
import com.tresor.createtransaction.view.activity.CreateTransactionView
import com.tresor.createtransaction.view.model.Post
import com.tresor.login.data.entity.mapper.FirebaseUserMapper
import com.tresor.login.data.firebase.FirebaseHandler
import com.tresor.login.data.repository.UserDataRepository
import com.tresor.login.data.repository.datasource.UserDataFactory
import com.tresor.login.domain.interactor.GetUID
import com.tresor.login.domain.model.UserLoginDomainModel
import java.util.HashMap

/**
 * @author atin on 5/23/2017.
 */
class CreateTransactionPresenterImpl(val view: CreateTransactionView) : CreateTransactionPresenter{
    private var mDatabase : DatabaseReference = FirebaseDatabase.getInstance().getReference()

    override fun getUid() {
        val getUid = GetUID(UserDataRepository(UserDataFactory(FirebaseHandler(), FirebaseUserMapper())), JobExecutor(), AndroidPostExecutionThread())
        getUid.execute(Unit, object : BaseObserver<UserLoginDomainModel>(){
            override fun onFailed(e: Throwable?) {
                view.goToLogin()
            }

            override fun onSuccess(t: UserLoginDomainModel) {
                view.storeUid(t.userId)
            }

        })
    }


    override fun submitTransaction(uid: String, date: String, info: String, nominal: String) {
        if (date.isEmpty()){
            view.showToast("Date")
            return
        }
        if (info.isEmpty()){
            view.showToast("Info")
            return
        }
        if (nominal.isEmpty()){
            view.showToast("Nominal")
            return
        }

        view.showLoading(true)

        val userId : String = uid

        mDatabase.child(userId).addListenerForSingleValueEvent(
                object : ValueEventListener{
                    override fun onCancelled(p0: DatabaseError?) {

                    }

                    override fun onDataChange(p0: DataSnapshot?) {
                        createTransaction(userId, date, info, nominal)
                    }

                }
        )

        view.showLoading(false)

    }



  fun createTransaction(uid: String, date: String, info: String, nominal: String) {

        val post = Post(nominal, info)
        val postValues = post.toMap()


        mDatabase.child(uid).child(date).push().setValue(postValues)
    }


}