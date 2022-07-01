package com.example.android.scribbles.data

class Userdata {
    private val _accountUserName : String? = null
    var accountUserName = _accountUserName!!

    fun createUser(userName: String) {
        //should add userNote to mutable list not return
        accountUserName = userName
    }

    fun getUser() : MutableList<String>{
        return mutableListOf()
    }

/*    fun addScribble(userNote: String){
        val updateList = createScribble(userNote)
        val input=AddActivity().addNewNote()
        updateList.add(input.toString())
    }*/
}
