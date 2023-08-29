package com.example.e_services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val start = findViewById<Button>(R.id.btn1)
        val stop = findViewById<Button>(R.id.btn2)

        start.setOnClickListener{
            startService(Intent(this,UnboundServices::class.java))
        }
        stop.setOnClickListener {
            stopService(Intent(this,UnboundServices::class.java))
        }

    }
}