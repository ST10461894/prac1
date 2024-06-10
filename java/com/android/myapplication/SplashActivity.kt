package com.android.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.content.Intent
import android.widget.Button

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {



    @SuppressLint("MissingInflatedId")

    private lateinit var btnStart:Button
    private lateinit var btnExit:Button

    @SuppressLint("CutPasteId", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.splash)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnExit=findViewById(R.id.btnExit)
        btnStart=findViewById(R.id.btnStart)

        btnStart.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnExit.setOnClickListener {
            finish()
        }
    }
    }




