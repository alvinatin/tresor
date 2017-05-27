package com.tresor.login.di.component

import com.tresor.base.di.component.AppComponent
import com.tresor.base.di.module.ActivityModule
import com.tresor.login.di.module.RegisterModule
import com.tresor.login.di.scope.RegisterScope
import com.tresor.login.view.activity.RegisterActivity
import dagger.Component

/**
 * @author sebastianuskh on 5/27/17.
 */
@RegisterScope
@Component(modules = arrayOf(ActivityModule::class, RegisterModule::class), dependencies = arrayOf(AppComponent::class))
interface RegisterComponent {
    fun inject(registerActivity: RegisterActivity)

}