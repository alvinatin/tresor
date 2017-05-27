package com.tresor.createtransaction.view.activity

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.*
import com.tresor.createtransaction.view.model.Post
import com.tresor.R
import com.tresor.createtransaction.view.presenter.CreateTransactionPresenter
import com.tresor.createtransaction.view.presenter.CreateTransactionPresenterImpl
import java.util.HashMap

class CreateTransactionActivity : AppCompatActivity(), CreateTransactionView {

    private val USER = "Atin"

    private val presenter : CreateTransactionPresenter = CreateTransactionPresenterImpl(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dateEditText = findViewById(R.id.et_date) as EditText
        val nominalEditText = findViewById(R.id.et_nominal) as EditText
        val infoEditText = findViewById(R.id.et_info) as EditText


        var send = findViewById(R.id.send_to_firebase) as Button

        send.setOnClickListener { presenter.submitTransaction(
                dateEditText.text.toString(),
                infoEditText.text.toString(),
                nominalEditText.text.toString()
        ) }
    }



    override fun showToast(string : String) {
        Toast.makeText(this, string+"cannot be empty", Toast.LENGTH_SHORT).show()
    }

    override fun showLoading(boolean: Boolean) {
        val dialog = ProgressDialog(this) // this = YourActivity
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        dialog.setMessage("Loading. Please wait...")
        dialog.isIndeterminate = true
        dialog.setCanceledOnTouchOutside(false)

        if (boolean){
            dialog.show()
        }
        if (!boolean){
            dialog.dismiss()
        }
    }

}

