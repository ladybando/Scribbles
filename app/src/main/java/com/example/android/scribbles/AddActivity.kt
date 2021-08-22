package com.example.android.scribbles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.scribbles.data.Userdata
import com.example.android.scribbles.ui.AddScribbleAdapter

class AddActivity : AppCompatActivity() {

    val newnote=findViewById<EditText>(R.id.new_note)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)


        //get user data
        val userData=Userdata().createScribble(newnote.text.toString())

        val recyclerView=findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter=AddScribbleAdapter(this, userData)
        recyclerView.layoutManager=LinearLayoutManager(this)

        //add user input to mutable list
        val submitNote : Button = findViewById(R.id.submit_button)
        submitNote.setOnClickListener{
            //add user data to list
            addNewNote()
            Userdata().addScribble(addNewNote().toString())
        }

        val backButton : ImageButton=findViewById(R.id.back_button)
        backButton.setOnClickListener{
            setContentView(R.layout.activity_add)
        }
    }

    fun addNewNote() : MutableList<String>{
        val userData=Userdata().createScribble(newnote.text.toString())
        val input = findViewById<EditText>(R.id.new_note).text.toString()
        userData.add(input)
        return userData
    }
}