package com.example.android.scribbles.data

import com.example.android.scribbles.AddActivity

class Userdata {
    fun createScribble(userNote: String): MutableList<String> {
        //should add userNote to mutable list not return
        return mutableListOf(userNote)
    }

    fun getScribble():MutableList<String>{
        return mutableListOf()
    }

    fun addScribble(userNote: String){
        val updateList = createScribble(userNote)
        val input=AddActivity().addNewNote()
        updateList.add(input.toString())
    }
}
