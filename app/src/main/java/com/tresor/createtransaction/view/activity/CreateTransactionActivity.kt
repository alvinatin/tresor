package com.tresor.createtransaction.view.activity

import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import com.tresor.R
import com.tresor.createtransaction.view.presenter.CreateTransactionPresenter
import com.tresor.createtransaction.view.presenter.CreateTransactionPresenterImpl
import com.tresor.login.view.activity.LoginActivity
import java.text.SimpleDateFormat
import java.util.*

class CreateTransactionActivity : AppCompatActivity(), CreateTransactionView {

    private lateinit var userId : String

    private val presenter : CreateTransactionPresenter = CreateTransactionPresenterImpl(this)
    private val loadingDialog: ProgressDialog by lazy{ProgressDialog(this)}

    private val calendar : Calendar = Calendar.getInstance();
    private var mYear = calendar.get(Calendar.YEAR);
    private var mMonth = calendar.get(Calendar.MONTH);
    private var mDay = calendar.get(Calendar.DAY_OF_MONTH);



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dateBtn = findViewById(R.id.btn_date) as Button
        dateBtn.setText(updateDate())
        val nominalEditText = findViewById(R.id.et_nominal) as EditText
        val infoEditText = findViewById(R.id.et_info) as EditText


        var send = findViewById(R.id.send_to_firebase) as Button

        presenter.getUid()

        // Create loading loadingDialog
        loadingDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        loadingDialog.setMessage("Loading. Please wait...")
        loadingDialog.isIndeterminate = true
        loadingDialog.setCanceledOnTouchOutside(false)

        val date : DatePickerDialog.OnDateSetListener = DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
            calendar.set(Calendar.YEAR, mYear)
            calendar.set(Calendar.MONTH, mMonth)
            calendar.set(Calendar.DAY_OF_MONTH, mDay)
            dateBtn.setText(updateDate())
        }

        dateBtn.setOnClickListener { DatePickerDialog(
                this,
                date,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).show() }

        send.setOnClickListener { presenter.submitTransaction(
                userId,
                updateDate(),
                infoEditText.text.toString(),
                nominalEditText.text.toString()
        )
            nominalEditText.setText("")
            infoEditText.setText("")
        }


    }

    override fun goToLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    override fun storeUid(userId: String) {
        this.userId = userId
    }

    override fun showToast(string : String) {
        Toast.makeText(this, string+" cannot be empty", Toast.LENGTH_SHORT).show()
    }

    override fun showLoading(boolean: Boolean) {


        if (boolean){
            loadingDialog.show()
        }
        if (!boolean){
            loadingDialog.dismiss()
        }
    }

    override fun updateDate() : String {
        val dateFormat : SimpleDateFormat = SimpleDateFormat("yyyy/MM/dd")
        val newDate : String = dateFormat.format(calendar.getTime())
        return newDate
    }


}

