package com.example.apidemo

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import java.net.URL
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLoad = findViewById<Button>(R.id.btnLoad)
        val txtResult = findViewById<TextView>(R.id.txtResult)

        btnLoad.setOnClickListener {

            thread {
                val apiUrl = "https://official-joke-api.appspot.com/random_joke"
                val response = URL(apiUrl).readText()

                val jsonObject = JSONObject(response)
                val setup = jsonObject.getString("setup")
                val punchline = jsonObject.getString("punchline")

                runOnUiThread {
                    txtResult.text = "$setup\n\n$punchline"
                }
            }
        }
    }
}
