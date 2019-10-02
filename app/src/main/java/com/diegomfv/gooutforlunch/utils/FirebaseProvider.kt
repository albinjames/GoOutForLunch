package com.diegomfv.gooutforlunch.utils

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import timber.log.Timber

object FirebaseProvider {

    var auth : FirebaseAuth? = null
    var user : FirebaseUser? = null
    var database: FirebaseDatabase? = null
    var storage: FirebaseStorage? = null

    var userEmail: String? = null
    var databaseRef : DatabaseReference? = null
    var storageRef : StorageReference? = null

    var userIsAdmin : Int = 0

    fun fillFirebaseSingletons () {
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        storage = FirebaseStorage.getInstance()
    }

    fun fillReferences () {
        user = auth?.currentUser
        userEmail = user?.email
        databaseRef = database?.reference
        storageRef = storage?.reference
    }

    fun printReferences () {
        Timber.i("FIREBASE_: user -> $user")
        Timber.i("FIREBASE_: userEmail -> $userEmail")
        Timber.i("FIREBASE_: databaseRef -> $databaseRef")
        Timber.i("FIREBASE_: storageRef -> $storageRef")
    }

    fun userIsAdmin () : Boolean {
        return userIsAdmin == 2
    }
}