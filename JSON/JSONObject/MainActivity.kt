package com.example.jsondemo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtId = findViewById<TextView>(R.id.txtId)
        val txtName = findViewById<TextView>(R.id.txtName)
        val txtCourse = findViewById<TextView>(R.id.txtCourse)
        val txtStatus = findViewById<TextView>(R.id.txtStatus)

        val jsonData = """
            {
              "id": 101,
              "name": "Kamal Perera",
              "course": "Mobile Application Development",
              "isRegistered": true
            }
        """

        val jsonObject = JSONObject(jsonData)

        val id = jsonObject.getInt("id")
        val name = jsonObject.getString("name")
        val course = jsonObject.getString("course")
        val status = jsonObject.getBoolean("isRegistered")

        txtId.text = "ID: $id"
        txtName.text = "Name: $name"
        txtCourse.text = "Course: $course"
        txtStatus.text = "Registered: $status"
    }
}
