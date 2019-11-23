package com.ninntra.development.model

import java.io.Serializable

class Album(var name: String, var numOfSongs: Int, var thumbnail: String): Serializable {

    constructor():this("",0,"")

    fun getAlbum():String{
        return "$name -> $numOfSongs -> $thumbnail"
    }
}