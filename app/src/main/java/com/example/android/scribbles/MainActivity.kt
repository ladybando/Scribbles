package com.example.android.scribbles

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.android.scribbles.data.Datasource
import com.example.android.scribbles.databinding.ActivityMainBinding
import com.example.android.scribbles.ui.ScribbleAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //load data
        val myDataset=Datasource().loadScribbles()

        //access views
        val recyclerView=binding.recyclerView
        recyclerView.adapter=ScribbleAdapter(this, myDataset)
        recyclerView.layoutManager=GridLayoutManager(this,2)
    }

}
