package com.ninntra.development.util

//import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

class FirebaseUtil {

    var firestoreDB = FirebaseFirestore.getInstance()
    //var user = FirebaseAuth.getInstance().currentUser

    // get all album from firestore
    fun getAlbumRef(): CollectionReference {
        //return firestoreDB.collection("users/${user!!.email.toString()}/saved_addresses")
        return firestoreDB.collection("album")
    }
}