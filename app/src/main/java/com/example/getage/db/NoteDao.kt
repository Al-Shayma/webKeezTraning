package com.example.getage.db

import androidx.room.*
import com.example.getage.util.Constants.NOTE_TABLE

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(noteEntity: NoteEntity)
    @Update
    fun updateNote(noteEntity: NoteEntity)
    @Delete
    fun delete(noteEntity: NoteEntity)
    @Query("SELECT * FROM $NOTE_TABLE ORDER BY noteId DESC ")
    fun getAllNotes(): MutableList<NoteEntity >
    @Query("SELECT * FROM $NOTE_TABLE WHERE noteId LIKE :id")
    fun getNote(id : Int) : NoteEntity
}