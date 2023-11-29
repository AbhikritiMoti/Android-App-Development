package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity4 : AppCompatActivity() {
    @SuppressLint("Range", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val addName: Button = findViewById(R.id.addName)
        val updateName: Button = findViewById(R.id.button)
        val deleteDetail: Button = findViewById(R.id.delete)
        val printName: Button = findViewById(R.id.printName)
        val enterName: EditText = findViewById(R.id.enterName)
        val enterAge: EditText = findViewById(R.id.enterAge)
        val Name: TextView = findViewById(R.id.Name)
        val Age: TextView = findViewById(R.id.Age)

        addName.setOnClickListener {
            val db = DBHelper(this, null)
            val name = enterName.text.toString()
            val age = enterAge.text.toString()
            db.addName(name, age)
            Toast.makeText(this, "$name added to database", Toast.LENGTH_LONG).show()
            enterName.text.clear()
            enterAge.text.clear()
        }

        printName.setOnClickListener {
            val db = DBHelper(this, null)
            val cursor = db.getName()
            Name.text = "Name\n\n"
            Age.text = "Age\n\n"
            cursor!!.moveToFirst()

            Name.append(cursor.getString(cursor.getColumnIndex(DBHelper.NAME_COl)) + "\n")
            Age.append(cursor.getString(cursor.getColumnIndex(DBHelper.AGE_COL)) + "\n")
            while (cursor.moveToNext()) {
                Name.append(cursor.getString(cursor.getColumnIndex(DBHelper.NAME_COl)) + "\n")
                Age.append(cursor.getString(cursor.getColumnIndex(DBHelper.AGE_COL)) + "\n")
            }
            cursor.close()
        }

        updateName.setOnClickListener {
            val dbHandler = DBHelper(this, null)
            dbHandler.updateCourse(
                enterName.text.toString(),
                enterAge.text.toString()
            )
            Toast.makeText(
                this@MainActivity4,
                "Course Updated..",
                Toast.LENGTH_SHORT
            ).show()
        }




        deleteDetail.setOnClickListener {
            val dbHandler = DBHelper(this, null)
            dbHandler.deleteDetail(
                enterAge.text.toString()
            )



            Toast.makeText(
                this@MainActivity4,
                "Data Deleted..",
                Toast.LENGTH_SHORT
            ).show()

        }
    }
}
