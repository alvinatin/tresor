package com.tresor.login.view.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.tresor.R
import com.tresor.base.view.BaseActivity
import com.tresor.login.di.component.DaggerLoginComponent
import com.tresor.login.di.module.LoginModule
import com.tresor.login.view.presenter.LoginPresenter
import javax.inject.Inject

/**
 * @author sebastianuskh on 5/20/17.
 */

open class LoginActivity: FormLoginActivity(), LoginView{

    val loginComponent by lazy {
        DaggerLoginComponent
                .builder()
                .appComponent(getAppComponent())
                .activityModule(getActivityModule())
                .loginModule(LoginModule())
                .build()}

    @Inject lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginComponent.inject(this)
        loginPresenter.view = this
        loginButton.text = getString(R.string.title_login)
        switchButton.text = getString(R.string.title_register)
    }

    override fun userAction(email: String, password: String) {
        loginPresenter.login(email, password)
    }

    override fun switchMode() {
        navigator.goToRegister(this)
    }
}