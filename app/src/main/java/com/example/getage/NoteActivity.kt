package com.example.getage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.room.Room
import com.example.getage.adapter.NoteAdapter
import com.example.getage.databinding.ActivityNoteBinding
import com.example.getage.db.NoteDatabase
import com.example.getage.ui.AddNoteActivity
import com.example.getage.util.Constants.NOTE_DATABASE

class NoteActivity : AppCompatActivity() {
    lateinit var loginBTN: Button
    lateinit var binding: ActivityNoteBinding

    private val noteDB: NoteDatabase by lazy {
        Room.databaseBuilder(this, NoteDatabase::class.java, NOTE_DATABASE)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
    private val noteAdapter by lazy { NoteAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAddNote.setOnClickListener {
            startActivity(Intent(this, AddNoteActivity::class.java))
        }
    }
}