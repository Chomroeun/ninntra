package com.ninntra.development.model

class Album {
    var name: String? = null
    var numOfSongs: Int = 0
    var thumbnail: Int = 0

    constructor() {}

    constructor(name: String, numOfSongs: Int, thumbnail: Int) {
        this.name = name
        this.numOfSongs = numOfSongs
        this.thumbnail = thumbnail
    }

}