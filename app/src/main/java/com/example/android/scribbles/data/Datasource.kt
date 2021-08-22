package com.example.android.scribbles.data

import com.example.android.scribbles.R
import com.example.android.scribbles.model.Scribbles

class Datasource {
    fun loadScribbles() : List<Scribbles>{
        return mutableListOf<Scribbles>(
            Scribbles(R.string.scribble1),
            Scribbles(R.string.scribble2),
            Scribbles(R.string.scribble3),
            Scribbles(R.string.scribble4),
            Scribbles(R.string.scribble5),
            Scribbles(R.string.scribble6))
    }

}
