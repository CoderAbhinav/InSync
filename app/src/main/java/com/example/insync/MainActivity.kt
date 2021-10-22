package com.example.insync

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.insync.services.authService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.LoginButton).setOnClickListener{
            showCredentials();

        }


    }

    private fun showCredentials(){
        val email = findViewById<EditText>(R.id.emailTextField).text;
        val psw = findViewById<EditText>(R.id.passwordTextField).text;
        val ls = authService();

        val x = ls.loginWithEmain(email = email.toString(), password = psw.toString());
        val msg = findViewById<TextView>(R.id.helloMessege);
        if(x){
            msg.text = "SUCESSFUl";
        }
        else{
            msg.text = "FAILED";
        }


    }

}
