package com.example.insync.services

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class authService {
    var done = false;

    public fun loginWithEmain(email:String, password:String):Boolean {
        val u =  FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val firebaseUser: FirebaseUser = task.result!!.user!!
                done = true
            }
        };


        return done
    }

}