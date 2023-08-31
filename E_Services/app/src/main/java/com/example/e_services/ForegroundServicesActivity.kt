package com.example.e_services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat

class ForegroundServicesActivity : AppCompatActivity() {
    lateinit var start:Button
    lateinit var stop:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foreground_services)

        start=findViewById(R.id.buttonStart)
        stop=findViewById(R.id.buttonStop)
        start.setOnClickListener {
            val startIntent = Intent(this,ForegroundServicesClass::class.java)
            startIntent.putExtra("inputExtra", "Foreground Services is running")
            ContextCompat.startForegroundService(this,startIntent)
        }

        stop.setOnClickListener {
            val stopIntent = Intent(this,ForegroundServicesClass::class.java)
//            stopIntent.putExtra("inputExtra", "Foreground Services is stopped")
            stopService(stopIntent)
        }
    }
}