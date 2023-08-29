package com.example.e_services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat

class ForegroundServiceActivityDemo : AppCompatActivity() {
    lateinit var start:Button
    lateinit var stop:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foreground_service_demo)

        start=findViewById(R.id.btn1)
        stop=findViewById(R.id.btn2)
        start.setOnClickListener {
            val startIntent = Intent(this,ForegroundDemo::class.java)
            startIntent.putExtra("inputExtra", "Foreground Services is running")
            ContextCompat.startForegroundService(this,startIntent)
        }

        stop.setOnClickListener {
            val stopIntent = Intent(this,ForegroundDemo::class.java)
            stopIntent.putExtra("inputExtra", "Foreground Services is stopped")
            stopService(stopIntent)
        }
    }
}