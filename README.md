SPLASH KT

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


SPLASH XML

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    android:id="@+id/splash"
    tools:context=".SplashActivity">

    <TextView
        android:id="@+id/tvAppName"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/screen_smart"
        android:textSize="24sp"
        android:textStyle="bold"
        android:paddingBottom="16dp"/>

    <TextView
        android:id="@+id/tvDeveloperName"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="10dp"
        android:text="@string/Mwansa_Yumbe"
        android:textSize="18sp"

        />

    <TextView
        android:id="@+id/tvStudentNumber"
        android:layout_width="wrap_content"
        android:layout_marginBottom="10dp"

        android:layout_height="wrap_content"
        android:text="@string/ST10461894"
        android:textSize="18sp"
        />

    <ImageView
        android:id="@+id/ivLogo"
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:contentDescription="@string/todo"
        android:src="@drawable/clocks"

        />

    <Button
        android:id="@+id/btnStart"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/start"
        android:backgroundTint="@color/black"
        android:layout_marginTop="16dp"

        />

    <Button
        android:id="@+id/btnExit"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/exit"
        android:backgroundTint="@color/black"
        android:layout_marginTop="16dp"
        />
</LinearLayout>

MAIN SCREEN XML

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp"
    android:id="@+id/main"
    android:gravity="center"
    tools:context=".MainActivity">

    <EditText
        android:id="@+id/etMorningTime"
        android:layout_width="320dp"
        android:layout_height="50dp"
         android:paddingStart="12dp"
       android:background="@drawable/edit_text_bg"
        android:hint="@string/enter_morning_screen_time_minutes"
        android:inputType="number"
        tools:ignore="RtlSymmetry" />

    <EditText
        android:id="@+id/etAfternoonTime"
        android:layout_width="320dp"
        android:layout_height="50dp"
        android:paddingStart="12dp"

        android:background="@drawable/edit_text_bg"
        android:hint="@string/enter_afternoon_screen_time_minutes"
        android:inputType="number"

        tools:ignore="RtlSymmetry" />
    <EditText
        android:id="@+id/etNote"
        android:layout_width="320dp"
        android:layout_height="50dp"
        android:paddingStart="12dp"

        android:background="@drawable/edit_text_bg"
        android:hint="@string/note"
        tools:ignore="RtlSymmetry" />
    <Button
        android:id="@+id/btnSave"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/save"
        android:backgroundTint="@color/black"
        android:layout_marginTop="40dp"
        android:layout_marginBottom="16dp"/>

    <Button
        android:id="@+id/btnViewDetails"
        android:backgroundTint="@color/black"

        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/view_details"
        android:layout_marginBottom="16dp"/>

    <Button
        android:id="@+id/btnClear"
        android:backgroundTint="@color/black"

        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/clear_data"/>
</LinearLayout>

MAIN SCREEN KT

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

DETAILED VIEW SCREEN XML

<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:tools="http://schemas.android.com/tools"
    android:padding="16dp"
    android:id="@+id/details"

    tools:context=".DetailActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
       android:gravity="center"
        android:orientation="vertical">

        <TextView
            android:id="@+id/tvDetails"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="@string/details_for_each_day"
            android:textSize="18sp"
            android:padding="15dp"
            android:background="@drawable/edit_text_bg"
            android:paddingBottom="16dp"/>

        <TextView
            android:id="@+id/tvAverage"
            android:background="@drawable/edit_text_bg"
            android:layout_width="match_parent"
            android:textStyle="bold"
            android:layout_height="wrap_content"
            android:text="@string/average_screen_time"
            android:padding="20dp"
            android:textSize="18sp"

            />

        <Button
            android:id="@+id/btnBack"
            android:backgroundTint="@color/black"
            android:layout_width="wrap_content"
            android:layout_marginTop="40dp"
            android:layout_height="wrap_content"
            android:text="@string/back_to_main_screen"/>
    </LinearLayout>
</ScrollView>


DETAILED VIEW SCREEN KT

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









PSEUDOCODE

Psuedocode

// SplashActivity

Class SplashActivity extends AppCompatActivity

    // Declare buttons
    Private btnStart: Button
    Private btnExit: Button

    // onCreate method
    Method onCreate(Bundle savedInstanceState)
        Call super.onCreate(savedInstanceState)
        Enable edge-to-edge display
        Set content view to activity_splash layout
        Apply window insets to splash view for system bars padding

        // Initialize buttons
        btnExit = FindViewById(R.id.btnExit)
        btnStart = FindViewById(R.id.btnStart)

        // Set onClick listeners for buttons
        btnStart.setOnClickListener
            Create intent to start MainActivity
            Start activity with intent

        btnExit.setOnClickListener
            Finish the current activity

    End Method

End Class

//MAIN ACTIVITY

// MainActivity

Class MainActivity extends AppCompatActivity

    // Declare lists and UI elements
    Private morningTimes: List<Int>
    Private afternoonTimes: List<Int>
    Private notes: List<String>

    Private etMorningTime: EditText
    Private etAfternoonTime: EditText
    Private etNote: EditText
    Private btnSave: Button
    Private btnViewDetails: Button
    Private btnClear: Button

    // onCreate method
    Method onCreate(Bundle savedInstanceState)
        Call super.onCreate(savedInstanceState)
        Set content view to activity_main layout
        Apply window insets to main view for system bars padding

        // Initialize UI elements
        etMorningTime = FindViewById(R.id.etMorningTime)
        etAfternoonTime = FindViewById(R.id.etAfternoonTime)
        etNote = FindViewById(R.id.etNote)
        btnSave = FindViewById(R.id.btnSave)
        btnViewDetails = FindViewById(R.id.btnViewDetails)
        btnClear = FindViewById(R.id.btnClear)

        // Set onClick listeners for buttons
        btnSave.setOnClickListener
            Get morning time from etMorningTime and convert to Int
            Get afternoon time from etAfternoonTime and convert to Int
            Get note from etNote

            If morning time and afternoon time are not null and note is not empty
                Add morning time to morningTimes
                Add afternoon time to afternoonTimes
                Add note to notes
                Show "Data saved successfully!" message
            Else
                Show "Please enter valid data." message

        btnViewDetails.setOnClickListener
            Create intent to start DetailActivity
            Put morningTimes, afternoonTimes, and notes in intent extras
            Start activity with intent

        btnClear.setOnClickListener
            Clear text fields etMorningTime, etAfternoonTime, etNote
            Clear lists morningTimes, afternoonTimes, notes
            Show "Data cleared!" message

    End Method

End Class


//DETAILED VIEW ACTIVITY

// DetailActivity

Class DetailActivity extends AppCompatActivity

    // Declare UI elements
    Private tvDetails: TextView
    Private tvAverage: TextView
    Private btnBack: Button

    // onCreate method
    Method onCreate(Bundle savedInstanceState)
        Call super.onCreate(savedInstanceState)
        Enable edge-to-edge display
        Set content view to activity_detail layout
        Apply window insets to details view for system bars padding

        // Initialize UI elements
        tvDetails = FindViewById(R.id.tvDetails)
        tvAverage = FindViewById(R.id.tvAverage)
        btnBack = FindViewById(R.id.btnBack)

        // Get data from intent extras
        morningTimes = Get int array extra "morningTimes" from intent
        afternoonTimes = Get int array extra "afternoonTimes" from intent
        notes = Get string array extra "notes" from intent

        // Display details
        Set tvDetails text to "Details for each day:\n"
        For each day index in morningTimes
            Append day details to tvDetails text

        // Calculate and display average screen time
        Total morning time = Sum of morningTimes
        Total afternoon time = Sum of afternoonTimes
        Average morning time = Total morning time / Size of morningTimes
        Average afternoon time = Total afternoon time / Size of afternoonTimes
        Average total time = Average morning time + Average afternoon time
        Set tvAverage text to "Average Screen Time: " + Average total time + " min"

        // Set onClick listener for back button
        btnBack.setOnClickListener
            Finish the current activity

    End Method

End Class



