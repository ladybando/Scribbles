package com.example.android.scribbles.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.android.scribbles.R
import com.example.android.scribbles.model.Scribbles
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ScribbleAdapter(private val context: Context, private val dataset: List<Scribbles>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    //TODO fix error :  java.lang.ClassCastException: com.example.android.scribbles.model.Scribbles cannot be cast to android.view.View
    companion object {
        private const val VIEW_TYPE_TEXT = 1//TODO find out what these do. this is causing error
        private const val VIEW_TYPE_BUTTON = 2
    }
//https://blog.mindorks.com/recyclerview-multiple-view-types-in-android most recent resource
    //create abstract class to provide access to two views
    abstract class BaseViewHolder<T>(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: View)
    }

    // Provide a reference to the views for each data item
    inner class ItemViewHolder1(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.scrib_text_view)
        fun bind(position: Int) {
            val viewModel1 = dataset[position]
            textView.text = viewModel1.toString()
        }
    }

    //Provide reference to floating action button
    inner class ItemViewHolder2(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val actionButton: FloatingActionButton = itemView.findViewById(R.id.fab)
        fun bind(position: Int) {
            val viewModel2 = dataset[position]
            actionButton.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_add_new))
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder {
        //create new view
        return when (viewType) {
            VIEW_TYPE_TEXT -> {
                val adapterLayout =
                    LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
                ItemViewHolder1(adapterLayout)
            }
            VIEW_TYPE_BUTTON -> {
                val mainLayout =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.activity_main, parent, false)
                ItemViewHolder2(mainLayout)
            }
            else -> throw IllegalArgumentException("Invalid view type")//block drops to exception
        }
    }

    //called by layout manager to replace contents of list view
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (dataset[position].stringResourceID == VIEW_TYPE_TEXT) {
            //TODO fix error java.lang.ClassCastException: com.example.android.scribbles.model.Scribbles cannot be cast to android.view.View
            (holder as ItemViewHolder1).bind(position)
        } else
            (holder as ItemViewHolder2).bind(position)
    }

    override fun getItemViewType(position: Int): Int {
        return dataset[position].stringResourceID
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}