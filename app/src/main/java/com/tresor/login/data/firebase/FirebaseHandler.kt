package com.tresor.login.data.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.tresor.login.data.exception.FirebaseHandlerException
import com.tresor.login.data.exception.FirebaseHandlerException.Companion.FAILED_TO_LOGIN
import com.tresor.login.data.exception.FirebaseHandlerException.Companion.FAILED_TO_REGISTER
import com.tresor.login.data.exception.FirebaseHandlerException.Companion.NOT_LOGGED_IN
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author sebastianuskh on 5/22/17.
 */
class FirebaseHandler @Inject constructor(){

    var auth = FirebaseAuth.getInstance()

    fun login(email: String, password: String): Observable<FirebaseUser> =
            Observable.create(
                    { e ->
                        auth.signInWithEmailAndPassword(email, password)
                                .addOnCompleteListener { task ->
                                    if (task.isSuccessful){
                                        e.onNext(auth.currentUser)
                                        e.onComplete()
                                    } else {
                                        e.onError(FirebaseHandlerException(FAILED_TO_LOGIN))
                                    }
                                }
                                .addOnFailureListener { task ->
                                    e.onError(FirebaseHandlerException(FAILED_TO_LOGIN, task.localizedMessage))
                                }
                    }
            )

    fun register(email: String, password: String): Observable<FirebaseUser> =
            Observable.create(
                    { e ->
                        auth.createUserWithEmailAndPassword(email, password)
                                .addOnCompleteListener { task ->
                                    if (task.isSuccessful){
                                        e.onNext(auth.currentUser)
                                        e.onComplete()
                                    } else {
                                        e.onError(FirebaseHandlerException(FAILED_TO_REGISTER))
                                    }
                                }
                                .addOnFailureListener { task ->
                                    e.onError(FirebaseHandlerException(FAILED_TO_REGISTER, task.localizedMessage))
                                }
                    }
            )

    fun getUID(): Observable<FirebaseUser> =
            Observable.create(
                    { e ->
                        if (auth.currentUser != null) {
                            e.onNext(auth.currentUser)
                            e.onComplete()
                        } else {
                            e.onError(FirebaseHandlerException(NOT_LOGGED_IN))
                        }
                    }
            )


}