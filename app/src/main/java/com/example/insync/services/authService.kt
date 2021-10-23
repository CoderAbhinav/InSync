package com.example.insync.services

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class authService {
    var done: Boolean = false;
    var uid:String = "NO";

    public fun loginWithEmain(email: String, password: String):Boolean {
        GlobalScope.launch {
            var auth = FirebaseAuth.getInstance();
            val addOnCompleteListener = auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener() { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.e("Firebase", "signInWithEmail:success")
                            uid = auth.currentUser?.uid.toString();
                            done = true;

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.e("Firebase", "signInWithEmail:failure", task.exception)
                            done = false;

                        }
                    }
            }
        return done
    }
}