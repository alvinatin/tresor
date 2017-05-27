package com.tresor.login.data.repository.datasource

import com.tresor.login.domain.model.UserLoginDomainModel
import io.reactivex.Observable

/**
 * @author sebastianuskh on 5/22/17.
 */
interface UserDataSource {

    fun login(email: String, password: String): Observable<UserLoginDomainModel>

    fun register(email: String, password: String): Observable<UserLoginDomainModel>

    fun getUID(): Observable<UserLoginDomainModel>
}