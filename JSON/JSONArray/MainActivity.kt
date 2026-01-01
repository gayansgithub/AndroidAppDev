package com.example.jsonarraydemo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtResult = findViewById<TextView>(R.id.txtResult)

        val jsonData = """
            {
              "students": [
                { "id": 1, "name": "Nimal", "course": "Android" },
                { "id": 2, "name": "Sunil", "course": "Web Development" },
                { "id": 3, "name": "Kamal", "course": "Networking" }
              ]
            }
        """

        val jsonObject = JSONObject(jsonData)
        val jsonArray = jsonObject.getJSONArray("students")

        val result = StringBuilder()

        for (i in 0 until jsonArray.length()) {
            val student = jsonArray.getJSONObject(i)

            val id = student.getInt("id")
            val name = student.getString("name")
            val course = student.getString("course")

            result.append("ID: $id\n")
            result.append("Name: $name\n")
            result.append("Course: $course\n\n")
        }

        txtResult.text = result.toString()
    }
}
