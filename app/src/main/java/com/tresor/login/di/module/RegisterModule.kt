package com.tresor.login.di.module

import com.tresor.login.data.repository.UserDataRepository
import com.tresor.login.data.repository.datasource.UserDataFactory
import com.tresor.login.di.scope.RegisterScope
import com.tresor.login.domain.interactor.Register
import com.tresor.login.domain.repository.UserRepository
import com.tresor.login.view.presenter.RegisterPresenter
import com.tresor.login.view.presenter.RegisterPresenterImpl
import dagger.Module
import dagger.Provides

/**
 * @author sebastianuskh on 5/27/17.
 */
@RegisterScope
@Module
class RegisterModule {

    @RegisterScope
    @Provides
    fun providePresenter(login: Register): RegisterPresenter = RegisterPresenterImpl(login)

    @RegisterScope
    @Provides
    fun provideUserRepository(userDataFactory: UserDataFactory): UserRepository = UserDataRepository(userDataFactory)

}