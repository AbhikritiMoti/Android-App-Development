package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity2 : AppCompatActivity() {
    lateinit var add : FloatingActionButton
    lateinit var setting: FloatingActionButton
    lateinit var home : FloatingActionButton
    var fabVisible = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        add = findViewById(R.id.idFABAdd)
        setting = findViewById(R.id.idFABSettings)
        home= findViewById(R.id.idFABHome)

        add.setOnClickListener{
            if(!fabVisible){
                home.show()
                setting.show()
                home.visibility = View.VISIBLE
                setting.visibility = View.VISIBLE
                add.setImageDrawable(resources.getDrawable(R.drawable.baseline_add_home_24))
                fabVisible = true
            }else{
                home.hide()
                setting.hide()
                home.visibility = View.GONE
                setting.visibility = View.GONE
                add.setImageDrawable(resources.getDrawable(R.drawable.baseline_add_home_24))
                fabVisible = false

            }
        }

    }
}