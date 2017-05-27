package com.tresor.base.navigator

import android.content.Context
import android.content.Intent
import com.tresor.login.view.activity.LoginActivity
import com.tresor.login.view.activity.RegisterActivity
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author sebastianuskh on 5/22/17.
 */
@Singleton
class Navigator @Inject constructor() {
    fun goToLogin(context: Context) {
        context.startActivity(Intent(context, LoginActivity::class.java))
    }

    fun goToRegister(context: Context) {
        context.startActivity(Intent(context, RegisterActivity::class.java))
    }

}