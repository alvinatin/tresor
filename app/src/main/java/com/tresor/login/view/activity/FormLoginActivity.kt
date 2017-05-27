package com.tresor.login.view.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.tresor.R
import com.tresor.base.view.BaseActivity

/**
 * @author sebastianuskh on 5/27/17.
 */
abstract class FormLoginActivity: BaseActivity() {

    lateinit var loginButton: Button
    lateinit var switchButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginButton = findViewById(R.id.login_button) as Button
        loginButton.setOnClickListener {
            val email = (findViewById(R.id.email_edit_text) as EditText).text.toString()
            val password = (findViewById(R.id.password_edit_text) as EditText).text.toString()
            userAction(email, password)
        }

        switchButton = findViewById(R.id.button_switch_login) as Button
        switchButton.setOnClickListener {
            switchMode()
        }

    }

    abstract fun switchMode()

    abstract fun userAction(email: String, password: String)
}