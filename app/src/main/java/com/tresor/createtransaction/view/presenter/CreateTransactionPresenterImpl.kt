package com.tresor.createtransaction.view.presenter

import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.tresor.createtransaction.view.activity.CreateTransactionActivity
import com.tresor.createtransaction.view.activity.CreateTransactionView
import com.tresor.createtransaction.view.model.Post
import java.util.HashMap

/**
 * @author atin on 5/23/2017.
 */
class CreateTransactionPresenterImpl(val view: CreateTransactionView) : CreateTransactionPresenter{

    private val USER : String = "Atin"
    private var mDatabase : DatabaseReference = FirebaseDatabase.getInstance().getReference()

    override fun submitTransaction(date: String, info: String, nominal: String) {
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
        //Get user id
        val userId : String = "tes"

        mDatabase.child(userId).addListenerForSingleValueEvent(
                object : ValueEventListener{
                    override fun onCancelled(p0: DatabaseError?) {

                    }

                    override fun onDataChange(p0: DataSnapshot?) {
                        createTransaction(userId, date, info, nominal)
                    }

                }
        )

    }



    override fun createTransaction(uid: String, date: String, info: String, nominal: String) {

        val post = Post(nominal, info)
        val postValues = post.toMap()

        mDatabase.child(uid).child(date).push().setValue(postValues)
    }


}