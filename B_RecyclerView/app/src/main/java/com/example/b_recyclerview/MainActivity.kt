package com.example.b_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    val list = ArrayList<MyDataModel>()
    lateinit var myAdap : RecyclerAdapterDemo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv: RecyclerView=findViewById(R.id.recyclerView)
        myAdap= RecyclerAdapterDemo(list)
        val layoutManager= LinearLayoutManager(applicationContext)
        rv.layoutManager=layoutManager
        rv.itemAnimator=DefaultItemAnimator()
        rv.adapter=myAdap
        call()

    }

    fun call(){
        val data =MyDataModel("Semester1","Cgpa9","2020")
        list.add(data)
        list.add(MyDataModel("Semester2","Cgpa8","2021"))
        list.add(MyDataModel("Semester3","Cgpa5","2026"))
        list.add(MyDataModel("Semester4","Cgpa6","2025"))
    }
}