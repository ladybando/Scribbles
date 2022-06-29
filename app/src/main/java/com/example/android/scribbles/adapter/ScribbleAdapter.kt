package com.example.android.scribbles.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.scribbles.R
import com.example.android.scribbles.databinding.FragmentNotesLayoutBinding

class ScribbleAdapter(private val context: Context, private val dataset: MutableList<String>) :
    RecyclerView.Adapter<ScribbleAdapter.NotesViewHolder>() {

    // Provide a reference to the views for each data item
    inner class NotesViewHolder(binding: FragmentNotesLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var textView: TextView = binding.scribTextView
    }

    //called by layout manager to replace contents of list view
    override fun onBindViewHolder(holder: ScribbleAdapter.NotesViewHolder, position: Int) = with(holder) {
        textView.text = dataset[position]

    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScribbleAdapter.NotesViewHolder {
        return NotesViewHolder(
            FragmentNotesLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}