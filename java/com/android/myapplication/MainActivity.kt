package com.android.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val morningTimes = mutableListOf<Int>()
    private val afternoonTimes = mutableListOf<Int>()
    private val notes = mutableListOf<String>()

    private lateinit var etMorningTime: EditText
    private lateinit var etAfternoonTime: EditText
    private lateinit var etNote: EditText
    private lateinit var btnSave: Button
    private lateinit var btnViewDetails: Button
    private lateinit var btnClear: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

           etMorningTime = findViewById(R.id.etMorningTime)
        etAfternoonTime = findViewById(R.id.etAfternoonTime)
        etNote = findViewById(R.id.etNote)
        btnSave = findViewById(R.id.btnSave)
        btnViewDetails = findViewById(R.id.btnViewDetails)
        btnClear = findViewById(R.id.btnClear)

           btnSave.setOnClickListener {
            val morningTime = etMorningTime.text.toString().toIntOrNull()
            val afternoonTime = etAfternoonTime.text.toString().toIntOrNull()
            val note = etNote.text.toString()

            if (morningTime != null && afternoonTime != null && note.isNotEmpty()) {
                morningTimes.add(morningTime)
                afternoonTimes.add(afternoonTime)
                notes.add(note)
                Toast.makeText(this, "Data saved successfully!", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this, "Please enter valid data.", Toast.LENGTH_SHORT).show()
            }
        }


        btnViewDetails.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("morningTimes", morningTimes.toIntArray())
            intent.putExtra("afternoonTimes", afternoonTimes.toIntArray())
            intent.putExtra("notes", notes.toTypedArray())
            startActivity(intent)
        }


        btnClear.setOnClickListener {
            etMorningTime.text.clear()
            etAfternoonTime.text.clear()
            etNote.text.clear()
            morningTimes.clear()
            afternoonTimes.clear()
            notes.clear()
            Toast.makeText(this, "Data cleared!", Toast.LENGTH_SHORT).show()
        }
    }
}
