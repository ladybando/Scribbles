package com.example.android.scribbles.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.android.scribbles.adapter.ScribbleAdapter
import com.example.android.scribbles.data.Datasource
import com.example.android.scribbles.databinding.FragmentNotesLayoutBinding

class NotesLayoutFragment : Fragment() {
    private var _binding: FragmentNotesLayoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotesLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //load data
        val myDataset= Datasource().loadScribbles()
/*
        //access views
        val recyclerView=binding.recyclerView
        recyclerView.adapter= ScribbleAdapter(this, myDataset)
        recyclerView.layoutManager= GridLayoutManager(this,2)*/
    }
}