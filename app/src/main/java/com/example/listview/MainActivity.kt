package com.example.listview

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var list = mutableListOf("One", "Two", "Three", "Four", "Five")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.list_view)
        val btn = findViewById<Button>(R.id.btn)
        val btnNext = findViewById<Button>(R.id.btn_next)
        val editText = findViewById<EditText>(R.id.edit_text)
        val adapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        listView.adapter = adapter
        listView.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, p2, _ -> Toast.makeText(this@MainActivity,
                list[p2], Toast.LENGTH_SHORT).show()
            }

        btn.setOnClickListener {
            adapter.add(editText.text.toString())
            editText.setText("")
        }
        btnNext.setOnClickListener {
            val intent = Intent(this@MainActivity, SpinnerActivity::class.java)
            startActivity(intent)
        }
    }
}