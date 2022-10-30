package com.vk.homework1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tables = generateTableList().toMutableList()

        val rv: RecyclerView = findViewById(R.id.activity_main__rv)
        val adapter = MainAdapter(tables)
        rv.adapter = adapter
        rv.layoutManager = GridLayoutManager(this, 3)

        val but: Button = findViewById(R.id.activity_main__button)
        but.setOnClickListener{
            tables.add( DataTables(
                tables.size

            ))
            adapter.notifyDataSetChanged()
        }
    }

    private fun generateTableList(): List<DataTables>{
        return listOf(
            DataTables(
                0
            ), DataTables(
                1
            ), DataTables(
                2
            ), DataTables(
                3
            ), DataTables(
                4
            ), DataTables(
                5
            ), DataTables(
                6
            ), DataTables(
                7
            ), DataTables(
                8
            )
        )
    }
}