package com.example.getage

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.getage.databinding.ActivityRecylcerViewBinding

class RecylcerViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecylcerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecylcerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pro = arrayListOf(
            Programmer(
                "Shaymaa",
                "trainee"
            ),
            Programmer(
                "Sara",
                "senior android"
            ),
            Programmer(
                "Yahia",
                "web developer"
            )
        )
        val programmerAdapter = ProgrammerAdapter(this, pro)
        binding.recyclerViewId.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewId.adapter = programmerAdapter
    }
}