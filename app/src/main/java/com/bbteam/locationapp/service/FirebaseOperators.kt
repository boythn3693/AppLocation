package com.bbteam.locationapp.service

import com.bbteam.locationapp.model.User
import com.google.firebase.database.*

class DatabaseOperators {

    private var mDatabase: DatabaseReference? = null

    init {
        mDatabase = FirebaseDatabase.getInstance().reference
    }

    fun write(st: String) {

    }

    fun read(key: String) {
        mDatabase!!.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError?) {
                println("Error: " + error)
            }

            override fun onDataChange(dataSnapshot: DataSnapshot?) {
                val data = dataSnapshot!!.getValue(User::class.java)
                println("data: " + data)
            }

        })
    }
}



