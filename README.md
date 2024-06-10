// SplashActivity

Start
    // Declare buttons
    Private btnStart: Button
    Private btnExit: Button

    // onCreate method
    Method onCreate(Bundle savedInstanceState)
        Call super.onCreate( savedInstanceState)
        Enable edge-to-edge display
        Set content view to activity splash layout
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

End 


// MainActivity

Start
    // Declare lists and UI elements
    Private morningTimes: List<Int>
    Private afternoonTimes: List<Int>
    Private notes: List<String>
    private low: List<String>
    private high: List<String>

    Private etlow: EditText
    Private ethigh: EditText
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
            Get low from high and convert to Int
            Get note from etNote

            If morning time and afternoon time are not null and note is not empty
                Add morning time to morningTimes
                Add low time to high
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
            Clear lists low, high notes
            Show "Data cleared!" message

    End Method

End 


//DETAILED VIEW ACTIVITY

Start
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

        // Calculate and display average weather
        Total morning time = Sum of low
        Total afternoon time = Sum of high
        Average morning time = Total low / Size of high
        Average afternoon time = Total high / Size of high
        Average total time = Average morning time + Average afternoon time
        Set tvAverage text to "Average weather " + Average total time + " min"

        // Set onClick listener for back button
        btnBack.setOnClickListener
            Finish the current activity

    End Method

End 

