package com.vk.homework1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vk.homework1.fragment.createFirstFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val trasaction = supportFragmentManager.beginTransaction()
            trasaction.add(R.id.container, createFirstFragment("Hello"))
            trasaction.commit()
        }
    }
}