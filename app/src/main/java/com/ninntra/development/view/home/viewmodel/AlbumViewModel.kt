package com.ninntra.development.view.home.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ninntra.development.model.Album

const val TAG = "ALBUM_VIEW_MODEL"

class AlbumViewModel: ViewModel(){

    var firebaseRepository = FirestoreRepository()
    var albums : MutableLiveData<List<Album>> = MutableLiveData()

    fun getAlbums(): LiveData<List<Album>>{
        firebaseRepository.getSavedAddress().addSnapshotListener { value, e ->
            if (e != null) {
                Log.w(TAG, "Listen failed.", e)
                albums.value = null
                return@addSnapshotListener
            }


            val albumList : MutableList<Album> = mutableListOf()
            for (doc in value!!) {
                val addressItem = doc.toObject(Album::class.java)
                albumList.add(addressItem)
            }
            albums.value = albumList
        }

        return albums
    }

}
