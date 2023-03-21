package com.example.planer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //button click
        btnLogin.setOnClickListener {
            //get values  from input field
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()
            //validation
            if(username.isEmpty()) // return true if username is empty
            {
                etUsername.error = "Enter username"
                etUsername.requestFocus() //to get the field selected(show cursor)
            }else if (password.isEmpty()){
                etPassword.error = "Enter password" //error message to show
                etPassword.requestFocus()
            }else //validation is successful
            {
                //open home/dashboard
                val intent = Intent(this,HomeActivity::class.java)
                startActivity(intent)

            }
        }

    }
}