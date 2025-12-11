package com.example.spinnerdemo

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Data for the spinner
        val countries = listOf("Sri Lanka", "India", "USA", "UK", "Australia")

        // Create adapter
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            countries
        )

        // Set adapter to the spinner
        spinnerCountry.adapter = adapter

        // Handle item selected event
        spinnerCountry.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedCountry = countries[position]
                txtResult.text = "Selected: $selectedCountry"
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                txtResult.text = "Nothing selected"
            }
        }
    }
}
