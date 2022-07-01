package com.example.android.scribbles.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.android.scribbles.R
import com.example.android.scribbles.data.Userdata
import com.example.android.scribbles.databinding.FragmentAddNewNoteBinding


class AddNewNoteFragment : Fragment() {
    private var _binding: FragmentAddNewNoteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddNewNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickButtons()
    }
  private fun onClickButtons(){       //add user input to mutable list
    val submitNote = binding.submitButton
    submitNote.setOnClickListener{
        //add user data to list
        addNewNote()
        //Userdata().addScribble(addNewNote().toString())
    }

    val backButton = binding.backButton
    backButton.setOnClickListener{
        //setContentView(R.layout.fragment_add_new_note)
    }
}

fun addNewNote() : MutableList<String>{
    val userData = Userdata().createUser(binding.newNote.text.toString())
    val input = binding.newNote.text.toString()

    return mutableListOf(input)
}
}