package com.example.insync.services

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class authService {
    var auth = FirebaseAuth.getInstance();
    var userID = "NONE";
    public fun login(email:String, password:String): String {
        var rev:String = "NONE"
        val launch = GlobalScope.launch {
            try {
                auth.signInWithEmailAndPassword(email, password)
                rev = auth.uid.toString()
                Log.d("Firebase1", rev)


            } catch (e: Exception) {
                rev = "NONE"
            }

        }
        return rev

    }


    public fun loginWithEmail(email:String, password: String){
        Log.d("CLASS1",userID)
        var user: FirebaseUser
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener(

        ){
            task ->
            if(task.isSuccessful){
                user= task.result!!.user!!
                Log.d("CLASS2",user.uid)

                userID = user.uid.toString()
            }
            else{
                Log.d("CLASS3","FAILED")
            }
        }

    }

}