package com.example.android.scribbles.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.android.scribbles.adapter.ScribbleAdapter
import com.example.android.scribbles.databinding.FragmentNotesLayoutBinding
import com.example.android.scribbles.databinding.ListItemBinding
import com.example.android.scribbles.model.ScribblesViewModel

class NotesLayoutFragment : Fragment(), ScribbleAdapter.Listener {
    private var _binding: ListItemBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ScribblesViewModel by activityViewModels()
    private lateinit var adapter: ScribbleAdapter

    //not inflating view if listItem called here
    //will inflate if fragment_notes... called here
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ListItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //load data
        viewModel.taskNote.observe(viewLifecycleOwner){ taskNotes ->
            adapter = ScribbleAdapter(this.requireActivity(), taskNotes, this)
            binding.recyclerView.adapter = adapter
        }

    }

    override fun onFabClicked(view: View) {
        val action = NotesLayoutFragmentDirections.actionNotesLayoutFragmentToAddNewNoteFragment()
        findNavController().navigate(action)
    }

    override fun onTaskNoteClicked(index: Int) {
        TODO("Not yet implemented")
    }
}