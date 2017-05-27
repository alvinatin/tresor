package com.tresor.login.view.presenter

import com.tresor.base.view.BaseObserver
import com.tresor.login.domain.interactor.Register
import com.tresor.login.domain.model.UserLoginDomainModel

/**
 * @author sebastianuskh on 5/27/17.
 */
class RegisterPresenterImpl(val register: Register) : RegisterPresenter(){
    override fun register(email: String, password: String) {
        register.execute(
                Register.Param(email, password),
                object: BaseObserver<UserLoginDomainModel>(){
                    override fun onFailed(e: Throwable?) {

                    }

                    override fun onSuccess(t: UserLoginDomainModel) {

                    }

                })
    }
}