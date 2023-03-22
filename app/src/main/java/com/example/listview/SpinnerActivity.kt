package com.example.listview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Spinner

class SpinnerActivity : AppCompatActivity() {
    var list = mutableListOf("One", "Two", "Three", "Four", "Five", "Six")
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val spinnerAdapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_spinner_item, list)
        spinner.adapter = spinnerAdapter

        val autoTV = findViewById<AutoCompleteTextView>(R.id.auto_tv)
        val adapterAutoTV : ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        autoTV.setAdapter(adapterAutoTV)
        autoTV.threshold = 1
    }
}