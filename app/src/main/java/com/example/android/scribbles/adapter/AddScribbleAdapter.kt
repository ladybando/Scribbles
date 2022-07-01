package com.example.android.scribbles.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.android.scribbles.R
import com.example.android.scribbles.data.Userdata

class AddScribbleAdapter(private val context: Context, private val newNote: MutableList<String>) : RecyclerView.Adapter<AddScribbleAdapter.NewItemViewHolder>() {
//todo return newNote list for use in app
private val noteList : MutableList<String>

    init {
        val notes= Userdata().getUser()
        noteList=notes
    }

    class NewItemViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val submitButton: Button=view.findViewById(R.id.submit_button)
        val textView : EditText=view.findViewById(R.id.new_note)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.fragment_add_new_note,parent,false)
        return NewItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: NewItemViewHolder, position: Int) {
        val item = newNote[position]
        holder.submitButton.text = "$item"
        holder.textView.text
    }

    override fun getItemCount(): Int {
        return newNote.size
    }

    fun deleteItem(position:Int){
        newNote.removeAt(position)
    }

    fun editItem(position: Int, view: View){
        val input = view.findViewById<EditText>(R.id.new_note)
        newNote.set(position,input.text.toString())
    }

    fun onViewCreated(){
        //TODO add functionality for after view is set. maybe add return of newNote here

        /*use text and button initialized above
        * get list from NewScribble
        * check if null
        * add new items
        * return list
        *
        * add method to update list (MutableList.set(index, element)) and then remove() items from list
        *
        * https://www.tutorialkart.com/kotlin/kotlin-mutable-list-set/  */
    }
}