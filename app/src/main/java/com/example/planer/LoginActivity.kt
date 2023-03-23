package com.example.planer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.planer.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.etPassword
import kotlinx.android.synthetic.main.activity_login.etEmailLog
import kotlinx.android.synthetic.main.activity_register.view.*

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Auth
        auth = FirebaseAuth.getInstance()

        //button click
        binding.btnLogin.setOnClickListener {
            //get values  from input field
            val email = etEmailLog.text.toString().trim()
            val password = etPassword.text.toString().trim()
            //validation
            if(email.isEmpty()) // return true if username is empty
            {
                etEmailLog.error = "Enter Email"
                etEmailLog.requestFocus() //to get the field selected(show cursor)
            }else if (password.isEmpty()){
                etPassword.error = "Enter password" //error message to show
                etPassword.requestFocus()
            }else //validation is successful
            {
                //open home/dashboard
                loginUser(email, password)
            }
        }

        textViewForget.setOnClickListener() {
            //open home/dashboard
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }

        textViewCreate.setOnClickListener() {
            //RegisterActivity
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }

    }

    private fun loginUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {login ->
                if (login.isSuccessful) {
                    Intent(this, HomeActivity::class.java).also {
                        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(it)
                        Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, login.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }
    }
}