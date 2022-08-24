package com.example.getage.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.getage.Communicator
import com.example.getage.adapter.NoteAdapter
import com.example.getage.databinding.ActivityMainBinding
import com.example.getage.db.NoteDatabase
import com.example.getage.util.Constants.NOTE_DATABASE


class MainActivity : AppCompatActivity(), Communicator {
    lateinit var loginBTN: Button
    lateinit var binding: ActivityMainBinding
    private val noteDB : NoteDatabase by lazy {
        Room.databaseBuilder(this,NoteDatabase::class.java,NOTE_DATABASE)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
    private val noteAdapter by lazy { NoteAdapter( ) }
 override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
     binding = ActivityMainBinding.inflate(layoutInflater)
     setContentView(binding.root)
binding.btnAddNote.setOnClickListener {
    startActivity(Intent(this,AddNoteActivity::class.java))
}







     //SharedPref:
//     val sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
//     val editor = sharedPref.edit()
//     binding.apply {
//         btnSave.setOnClickListener {
//             val userName = editUserName.text.toString()
//             val email = editEmail.text.toString()
//
//
//             editor.apply {
//               putString("user_name",userName)
//                 putString("email",email)
//                 apply()
//             }
//         }
//         btnLoad.setOnClickListener {
//             val userName = sharedPref.getString("user_name",null)
//             val email = sharedPref.getString("email",null)
//
//             tvUserName.text = userName
//             tvEmail.text = email
//         }
//     }

//     val pro = arrayListOf(
//         Programmer(
//             "Shaymaa",
//             "trainee"
//         ),
//         Programmer(
//             "Sara",
//             "senior android"
//         ),
//         Programmer(
//             "Yahia",
//             "web developer"
//         )
//     )
//       val programmerAdapter = ProgrammerAdapter(this,pro)
//     binding.recyclerViewId.layoutManager = LinearLayoutManager(this)
//      binding.recyclerViewId.adapter = programmerAdapter

//        val yearOfBirthET = findViewById<EditText>(R.id.yearOfBirth_EditText)
//        val ageTV = findViewById<TextView>(R.id.age_textView)
//        loginBTN=findViewById(R.id.loginBtn)
//
//        val clickNow = findViewById<Button>(R.id.clickNowB);
//        clickNow.setOnClickListener {
//            Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()
//            val calculateBT = findViewById<Button>(R.id.calculate_button)
//
//            calculateBT.setOnClickListener {
////            val yOB = yearOfBirthET.editableText.toString()
////            val age = 2022 - yOB.toInt()
////            ageTV.text = age.toString()
////            Toast.makeText(this,"button Clicked",Toast.LENGTH_SHORT).show()
//                var intent = Intent(this, MainActivity2::class.java)
//                intent.putExtra("name", "shimaa")
//
//                startActivity(intent)
//            }
//
//            var programmer = Programmer()
//            Log.i(
//                MainActivity::class.java.simpleName,
//                "programme has laptob ${programmer.hasLaptob}"
//            )
//            programmer.work()
//            programmer.talk()
//
//            var sales = SalesMan()
//            sales.createPyramid(4)
//            sales.talk()
//
//
//            var today = DayOfWeeks.WED
//            println(today)
//        }
     checkItem()
    }

    override fun onResume() {
        super.onResume()
        checkItem()
    }
    private fun checkItem(){
        binding.apply {
            if(noteDB.dao().getAllNotes().isNotEmpty()){
                rvNoteList.visibility= View.VISIBLE
                tvEmpText.visibility= View.GONE
                noteAdapter.differ.submitList(noteDB.dao().getAllNotes())
                setupRecyclerView()
            }else{
                rvNoteList.visibility= View.GONE
                tvEmpText.visibility= View.VISIBLE
            }

        }
    }
    private fun setupRecyclerView(){
        binding.rvNoteList.apply {
            layoutManager=LinearLayoutManager(this@MainActivity)
            adapter=noteAdapter
        }
    }
//
    override fun passDatacom(editTextInput: String) {
        TODO("Not yet implemented")
    }

//    override fun passDatacom(editTextInput: String) {
//        val bundle = Bundle()
//        bundle.putString("message", editTextInput)
//        val transaction = this.supportFragmentManager.beginTransaction()
//        val fragmentB = FragmentB()
//        fragmentB.arguments = bundle
//        transaction.replace(R.id.fragmentContainer, fragmentB)
//        transaction.commit()
//
//
// intent :
//const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"
//
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }
//
//    /** Called when the user taps the Send button */
//    fun sendMessage(view: View) {
//        val editText = findViewById<EditText>(R.id.editTextTextPersonName)
//        val message = editText.text.toString()
//        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
//            putExtra(EXTRA_MESSAGE, message)
//        }
//        startActivity(intent)
//    }
//}
//intent sec Activity :
//override fun onCreate(savedInstanceState: Bundle?) {
//    super.onCreate(savedInstanceState)
//    setContentView(R.layout.activity_display_message)
//
//    // Get the Intent that started this activity and extract the string
//    val message = intent.getStringExtra(EXTRA_MESSAGE)
//
//    // Capture the layout's TextView and set the string as its text
//    val textView = findViewById<TextView>(R.id.textView).apply {
//        text = message
//    }
//}
//
//
//
//
// Adapter code :
//val PROJECTION = arrayOf(Contacts.People._ID, People.NAME)
//...
//
//// Get a Spinner and bind it to an ArrayAdapter that
//// references a String array.
//
//
//// Load a Spinner and bind it to a data query.
//val spinner2: Spinner = findViewById(R.id.spinner2)
//val cursor: Cursor = managedQuery(People.CONTENT_URI, PROJECTION, null, null, null)
//val adapter2 = SimpleCursorAdapter(this,
//        // Use a template that displays a text view
//        android.R.layout.simple_spinner_item,
//        // Give the cursor to the list adapter
//        cursor,
//        // Map the NAME column in the people database to...
//        arrayOf(People.NAME),
//        // The "text1" view defined in the XML template
//        intArrayOf(android.R.id.text1))
//adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//spinner2.adapter = adapter2
//
// spinner code:
//val spinner: Spinner = findViewById(R.id.spinner)
//// Create an ArrayAdapter using the string array and a default spinner layout
//ArrayAdapter.createFromResource(
//        this,
//        R.array.planets_array,
//        android.R.layout.simple_spinner_item
//).also { adapter ->
//    // Specify the layout to use when the list of choices appears
//    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//    // Apply the adapter to the spinner
//    spinner.adapter = adapter
//Responding to User Selections:
//class SpinnerActivity : Activity(), AdapterView.OnItemSelectedListener {
//
//    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
//        // An item was selected. You can retrieve the selected item using
//        // parent.getItemAtPosition(pos)
//    }
//
//    override fun onNothingSelected(parent: AdapterView<*>) {
//        // Another interface callback
//    }
//
//checkboxes:
//fun onCheckboxClicked(view: View) {
//    if (view is CheckBox) {
//        val checked: Boolean = view.isChecked
//
//        when (view.id) {
//            R.id.checkbox_meat -> {
//                if (checked) {
//                    // Put some meat on the sandwich
//                } else {
//                    // Remove the meat
//                }
//            }
//            R.id.checkbox_cheese -> {
//                if (checked) {
//                    // Cheese me
//                } else {
//                    // I'm lactose intolerant
//                }
//            }
//            // TODO: Veggie sandwich
//        }
//    }
//
//
//
//}
//
//}
//}
//    }
}