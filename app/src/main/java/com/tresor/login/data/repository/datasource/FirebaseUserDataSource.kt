package com.tresor.login.data.repository.datasource

import com.tresor.login.data.entity.mapper.FirebaseUserMapper
import com.tresor.login.data.firebase.FirebaseHandler
import com.tresor.login.domain.model.UserLoginDomainModel
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author sebastianuskh on 5/22/17.
 */
class FirebaseUserDataSource @Inject constructor(var handler: FirebaseHandler, var mapper: FirebaseUserMapper) : UserDataSource {

    override fun register(email: String, password: String): Observable<UserLoginDomainModel> =
            handler.register(email, password).map(mapper)

    override fun getUID(): Observable<UserLoginDomainModel> =
            handler.getUID().map(mapper)

    override fun login(email: String, password: String) : Observable<UserLoginDomainModel> =
            handler.login(email, password).map(mapper)

}