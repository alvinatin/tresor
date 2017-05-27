package com.tresor.login.view.activity

import android.os.Bundle
import com.tresor.R
import com.tresor.login.di.component.DaggerRegisterComponent
import com.tresor.login.di.module.RegisterModule
import com.tresor.login.view.presenter.RegisterPresenter
import javax.inject.Inject

/**
 * @author sebastianuskh on 5/27/17.
 */

class RegisterActivity: FormLoginActivity(), RegisterView{
    val component by lazy {
        DaggerRegisterComponent
                .builder()
                .appComponent(getAppComponent())
                .activityModule(getActivityModule())
                .registerModule(RegisterModule())
                .build()
    }

    @Inject lateinit var registerPresenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component.inject(this)
        registerPresenter.view = this
        loginButton.text = getString(R.string.title_register)
        switchButton.text = getString(R.string.title_login)
    }

    override fun userAction(email: String, password: String) {
        registerPresenter.register(email, password)
    }

    override fun switchMode() {
        navigator.goToLogin(this)
    }

}
