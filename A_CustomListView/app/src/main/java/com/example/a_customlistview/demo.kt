package com.example.a_customlistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView

class demo(context: Context, val resource : Int, var objects: MutableList<DataModelClass>):
    ArrayAdapter<DataModelClass>(context,resource,objects) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater= LayoutInflater.from(context)

        val view:View=layoutInflater.inflate(resource,null)
        val imageView: ImageView =view.findViewById(R.id.imageView)

        val title: TextView =view.findViewById(R.id.title)

        val cb: CheckBox =view.findViewById(R.id.checkBox)

        val description:TextView=view.findViewById(R.id.desc)

        val btn: Button =view.findViewById(R.id.status)

        val item:DataModelClass=objects[position]

        imageView.setImageDrawable(context.resources.getDrawable(item.img))
        title.text=item.title
        description.text=item.desc

        btn.tag=position

        btn.setOnClickListener{
            val itemselected=objects.get(btn.tag as Int)
            objects.remove(itemselected)
            notifyDataSetChanged()
        }

        cb.tag=position

        cb.setOnClickListener{
            val itemselected=objects.get(btn.tag as Int)


        }

        return  view
    }
}