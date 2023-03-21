package com.example.planer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.etPassword
import kotlinx.android.synthetic.main.activity_login.etUsername
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //button click
        btnRegisterUser.setOnClickListener {
            //get values  from input field
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val firstname = etFirstname.text.toString().trim()
            val lastname = etLastname.text.toString().trim()
            val email = etEmail.text.toString().trim()
            //validation
            if(username.isEmpty()) // return true if username is empty
            {
                etUsername.error = "Enter username"
                etUsername.requestFocus() //to get the field selected(show cursor)
            }else if (password.isEmpty()){
                etPassword.error = "Enter password" //error message to show
                etPassword.requestFocus()
            }else if (firstname.isEmpty()){
                etFirstname.error = "Enter First name" //error message to show
                etFirstname.requestFocus()
            }else if (lastname.isEmpty()){
                etLastname.error = "Enter Last name" //error message to show
                etLastname.requestFocus()
            }else if (email.isEmpty()){
                etEmail.error = "Enter Email" //error message to show
                etEmail.requestFocus()
            }else //validation is successful
            {
                //LoginActivity/dashboard
                val intent = Intent(this,LoginActivity::class.java)
                startActivity(intent)
            }
        }
            textViewLogin.setOnClickListener() {
                //open home/dashboard
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
    }
}