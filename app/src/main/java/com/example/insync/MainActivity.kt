package com.example.insync

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.LoginButton).setOnClickListener{
            showCredentials();
        }
    }

    private fun showCredentials(){
//        GlobalScope.launch {

            val email = findViewById<EditText>(R.id.emailTextField)
            val psw = findViewById<EditText>(R.id.passwordTextField)
//
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email.text.toString(), psw.text.toString()).addOnCompleteListener(

            ){
                task ->
                if(task.isSuccessful){
                    val user: FirebaseUser = task.result!!.user!!
                    Toast.makeText(this@MainActivity, user.uid,Toast.LENGTH_SHORT).show()
                    setContentView(R.layout.activity_home)

                }
                else{
                    Toast.makeText(this@MainActivity, "FAILED",Toast.LENGTH_SHORT).show()
                }
            }

//        }

    }




}
