package com.tresor.createtransaction.view.presenter

/**
 * @author atin on 5/23/2017.
 */
interface CreateTransactionPresenter {
    fun createTransaction(uid: String, date: String, info: String, nominal: String)

    fun submitTransaction(date: String, info: String, nominal: String)
}