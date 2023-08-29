package com.example.e_services

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class BoundServices : AppCompatActivity() {

    lateinit var start: Button
    lateinit var stop:Button
    lateinit var
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bound_services)

        start=findViewById(R.id.btn1)
        stop=findViewById(R.id.btn2)
        start.setOnClickListener {

        }
        stop.setOnClickListener {

        }

    }
}