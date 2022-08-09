package com.example.getage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val yearOfBirthET = findViewById<EditText>(R.id.yearOfBirth_EditText)
        val ageTV = findViewById<TextView>(R.id.age_textView)
        val calculateBT = findViewById<Button>(R.id.calculate_button)
        calculateBT.setOnClickListener {
//            val yOB = yearOfBirthET.editableText.toString()
//            val age = 2022 - yOB.toInt()
//            ageTV.text = age.toString()
            var intent = Intent(this,MainActivity2::class.java)
            intent.putExtra("name","shimaa")

            startActivity(intent)
        }

        var programmer = Programmer()
        Log.i(MainActivity::class.java.simpleName, "programme has laptob ${programmer.hasLaptob}")
        programmer.work()
        programmer.talk()

        var sales = SalesMan()
        sales.createPyramid(4)
        sales.talk()


        var today = DayOfWeeks.WED
        println(today)
    }
}