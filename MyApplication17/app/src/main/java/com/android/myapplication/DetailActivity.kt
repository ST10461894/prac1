package com.android.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    private lateinit var tvDetails:TextView
    private lateinit var tvAverage:TextView
    private lateinit var btnBack:Button
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.details)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvDetails = findViewById(R.id.tvDetails)
        tvAverage = findViewById(R.id.tvAverage)
        btnBack = findViewById(R.id.btnBack)

        val morningTimes = intent.getIntArrayExtra("morningTimes")?.toList() ?: listOf()
        val afternoonTimes = intent.getIntArrayExtra("afternoonTimes")?.toList() ?: listOf()
        val notes = intent.getStringArrayExtra("notes")?.toList() ?: listOf()

        tvDetails.text = "Details for each day:\n"
        for (i in morningTimes.indices) {
            tvDetails.append("Day ${i + 1}: Morning: ${morningTimes[i]} min, Afternoon: ${afternoonTimes[i]} min, Activity: ${notes[i]}\n")
        }
         val totalMorning = morningTimes.sum()
        val totalAfternoon = afternoonTimes.sum()
        val averageMorning = if (morningTimes.isNotEmpty()) totalMorning / morningTimes.size else 0
        val averageAfternoon = if (afternoonTimes.isNotEmpty()) totalAfternoon / afternoonTimes.size else 0
        val averageTotal = averageMorning + averageAfternoon

        tvAverage.text = "Average Screen Time: $averageTotal min"

        btnBack.setOnClickListener {
            finish()
        }
    }
    }



