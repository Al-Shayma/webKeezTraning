package com.example.getage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.getage.databinding.NavActivityBinding

class NavActivity : AppCompatActivity() {
    lateinit var binding: NavActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NavActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}

