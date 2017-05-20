package com.tresor

import android.support.v7.widget.RecyclerView
import android.widget.TextView

/**
 * @author atin on 5/20/2017.
 */
class MainViewHolder(private val view : TextView) : RecyclerView.ViewHolder(view){
    fun setText(string: String) {view.text = string}
}