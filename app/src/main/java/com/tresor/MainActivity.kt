package com.tresor

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById(R.id.main_recycler_view) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        val list = ArrayList<String>()
        list.add("atin")
        list.add("kris")
        list.add("sebo")
        list.add("lyvi")
        list.add("jon")
        recyclerView.adapter = MainAdapter(list)


    }
}
