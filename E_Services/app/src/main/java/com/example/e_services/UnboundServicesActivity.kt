package com.example.e_services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class UnboundServicesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unbound_services)

        val start = findViewById<Button>(R.id.startButton)
        val stop = findViewById<Button>(R.id.stopButton)

        start.setOnClickListener{
            startService(Intent(this,UnboundServicesClass::class.java))
        }
        stop.setOnClickListener {
            stopService(Intent(this,UnboundServicesClass::class.java))
        }

    }
}