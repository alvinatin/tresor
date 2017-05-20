package com.tresor

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

/**
 * @author atin on 5/20/2017.
 */
class MainAdapter(private val list: List<String>) : RecyclerView.Adapter<MainViewHolder>() {

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.setText(list.get(position))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainViewHolder {
        val textView = TextView(parent?.context)
        return MainViewHolder(textView)
    }
}