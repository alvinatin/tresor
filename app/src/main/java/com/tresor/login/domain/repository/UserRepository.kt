package com.tresor.login.domain.repository

import com.tresor.login.domain.model.UserLoginDomainModel
import io.reactivex.Observable

/**
 * @author sebastianuskh on 5/22/17.
 */
interface UserRepository {
    fun login(email: String, password: String): Observable<UserLoginDomainModel>

    fun register(email: String, password: String): Observable<UserLoginDomainModel>

    fun getUID(): Observable<UserLoginDomainModel>
}