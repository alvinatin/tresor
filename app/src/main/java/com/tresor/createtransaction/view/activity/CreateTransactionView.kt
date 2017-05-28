package com.tresor.createtransaction.view.activity

/**
 * @author atin on 5/27/2017.
 */
interface CreateTransactionView {
    fun showLoading(boolean: Boolean)

    fun showToast(string : String)
    fun storeUid(userId: String)
    fun goToLogin()
    fun updateDate() : String

}