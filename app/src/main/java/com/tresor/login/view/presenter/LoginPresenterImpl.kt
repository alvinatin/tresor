package com.tresor.login.view.presenter

import com.tresor.base.view.BaseObserver
import com.tresor.login.domain.interactor.Login
import com.tresor.login.domain.model.UserLoginDomainModel
import com.tresor.login.view.activity.LoginView

/**
 * @author sebastianuskh on 5/20/17.
 */
class LoginPresenterImpl(val login: Login): LoginPresenter() {

    override fun login(email: String, password: String) {
        val param = Login.Param(email, password)
        login.execute(param, LoginObserver(view))
    }

    class LoginObserver(val view: LoginView): BaseObserver<UserLoginDomainModel>() {
        override fun onFailed(e: Throwable?) {

        }

        override fun onSuccess(t: UserLoginDomainModel) {
            view.goToTransaction()
        }
    }
}
