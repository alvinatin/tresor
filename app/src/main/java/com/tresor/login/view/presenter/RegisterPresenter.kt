package com.tresor.login.view.presenter

import com.tresor.base.view.BasePresenter
import com.tresor.login.view.activity.RegisterView

/**
 * @author sebastianuskh on 5/27/17.
 */
abstract class RegisterPresenter: BasePresenter<RegisterView>() {
    abstract fun register(email: String, password: String)
}