package com.example.insync.services

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class authService {
    var done: Boolean = false;

    public fun loginWithEmain(email: String, password: String):Boolean {
        GlobalScope.launch {
            var auth = FirebaseAuth.getInstance();
            val addOnCompleteListener = auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener() { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("Firebase", "signInWithEmail:success")
                            val user = auth.currentUser
                            done = true

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("Firebase", "signInWithEmail:failure", task.exception)


                        }
                    }
            }
        return done
    }
}