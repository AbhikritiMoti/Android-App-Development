package com.example.a_customlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class CustomListViewMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customlistviewmain)

        val listView=findViewById<ListView>(R.id.listview)
        val list = mutableListOf<CustomListView_DataModelClass>()

        list.add(CustomListView_DataModelClass("item1","description 1",R.drawable.baseline_person_24))
        list.add(CustomListView_DataModelClass("item2","description 2",R.drawable.baseline_person_24))
        list.add(CustomListView_DataModelClass("item3","description 3",R.drawable.baseline_person_24))
        list.add(CustomListView_DataModelClass("item4","description 4",R.drawable.baseline_person_24))
        list.add(CustomListView_DataModelClass("item5","description 5",R.drawable.baseline_person_24))
        list.add(CustomListView_DataModelClass("item6","description 6",R.drawable.baseline_person_24))
        list.add(CustomListView_DataModelClass("item7","description 7",R.drawable.baseline_person_24))
        list.add(CustomListView_DataModelClass("item8","description 8",R.drawable.baseline_person_24))

        listView.adapter=CustomListViewAdapter(this,R.layout.customlistview_layout,list)
    }
}