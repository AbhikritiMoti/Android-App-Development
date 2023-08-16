package com.example.a_customlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView=findViewById<ListView>(R.id.listview)
        val list = mutableListOf<DataModelClass>()

        list.add(DataModelClass("item1","nhdbejkdbewj",R.drawable.baseline_person_24))
        list.add(DataModelClass("item2","nbckjdcbeuiwcbkj",R.drawable.baseline_person_24))
        list.add(DataModelClass("item3","nbchbewcweh",R.drawable.baseline_person_24))
        list.add(DataModelClass("item4","mnmnbcjkshbciuwh",R.drawable.baseline_person_24))
        list.add(DataModelClass("item5","cjbsiubuihdsk",R.drawable.baseline_person_24))
        list.add(DataModelClass("item6","jknbjuwhdoiwhd",R.drawable.baseline_person_24))
        list.add(DataModelClass("item7","kjbwuihdbiwuq",R.drawable.baseline_person_24))
        list.add(DataModelClass("item8","jbjxsauixhbqoquw",R.drawable.baseline_person_24))

        listView.adapter=demo(this,R.layout.custom_layout,list)
    }
}