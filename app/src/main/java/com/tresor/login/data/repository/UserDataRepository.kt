package com.tresor.login.data.repository

import com.tresor.login.data.repository.datasource.UserDataFactory
import com.tresor.login.domain.model.UserLoginDomainModel
import com.tresor.login.domain.repository.UserRepository
import io.reactivex.Observable

/**
 * @author sebastianuskh on 5/22/17.
 */
class UserDataRepository(val userDataFactory: UserDataFactory) : UserRepository {
    override fun register(email: String, password: String): Observable<UserLoginDomainModel> {
        val dataSource = userDataFactory.createFirebaseDataSource()
        return dataSource.register(email, password)
    }

    override fun getUID(): Observable<UserLoginDomainModel> {
        val dataSource = userDataFactory.createFirebaseDataSource()
        return dataSource.getUID()
    }

    override fun login(email: String, password: String): Observable<UserLoginDomainModel> {
        val dataSource = userDataFactory.createFirebaseDataSource()
        return dataSource.login(email, password)
    }
}