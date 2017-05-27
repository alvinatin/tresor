package com.tresor.login.domain.interactor

import com.tresor.base.domain.PostExecutionThread
import com.tresor.base.domain.ThreadExecutor
import com.tresor.base.domain.UseCase
import com.tresor.login.domain.model.UserLoginDomainModel
import com.tresor.login.domain.repository.UserRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author sebastianuskh on 5/27/17.
 */

class GetUID @Inject constructor(val userRepository: UserRepository, threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread):
        UseCase<Unit, UserLoginDomainModel> (threadExecutor, postExecutionThread) {
    override fun getObservable(param: Unit): Observable<UserLoginDomainModel> = userRepository.getUID()

}
