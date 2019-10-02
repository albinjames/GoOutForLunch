package com.diegomfv.gooutforlunch.utils

import com.google.firebase.database.DatabaseReference
import com.google.firebase.storage.StorageReference

object FirebaseQueryBuilder {

    fun queryChildren(databaseReference: DatabaseReference, vararg queries: String): DatabaseReference {
        var ref = databaseReference
        for (query in queries) {
            ref = ref.child(query)
        }
        return ref
    }

    fun queryChildren(storageReference: StorageReference, vararg queries: String): StorageReference {
        var ref = storageReference
        for (query in queries) {
            ref = ref.child(query)
        }
        return ref
    }
}