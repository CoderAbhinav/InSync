package com.example.insync

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.LoginButton).setOnClickListener{
            showCredentials();
        }


    }

    private fun showCredentials(){
        val email = findViewById<EditText>(R.id.emailTextField);
        val psw = findViewById<EditText>(R.id.passwordTextField);
        val msg = findViewById<TextView>(R.id.helloMessege);
        msg.text = "Hello, "+ email.text+" ";

    }

}
