package com.tresor.login.data.exception

import android.support.annotation.IntDef

/**
 * @author sebastianuskh on 5/22/17.
 */
data class FirebaseHandlerException(@FirebaseError val errorCode: Long, val errorMessage: String = "") : RuntimeException() {

    @IntDef(FAILED_TO_LOGIN, FAILED_TO_REGISTER, NOT_LOGGED_IN)
    @Retention(AnnotationRetention.SOURCE)
    annotation class FirebaseError

    companion object{
        const val FAILED_TO_LOGIN = 1L
        const val FAILED_TO_REGISTER = 2L
        const val NOT_LOGGED_IN = 2L

    }

}

