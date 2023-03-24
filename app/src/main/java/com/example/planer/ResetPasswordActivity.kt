package com.example.planer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.planer.databinding.ActivityResetPasswordBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_reset_password.*

class ResetPasswordActivity : AppCompatActivity() {

    private lateinit var  etPassword: EditText
    private lateinit var btnResetPassword: Button
    private lateinit var binding: ActivityResetPasswordBinding

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)



        etPassword = findViewById(R.id.etEmailForget)
        btnResetPassword = findViewById(R.id.btnRestartUser)

        //Auth
        auth = FirebaseAuth.getInstance()

        //Reset password
        btnResetPassword.setOnClickListener {
            val email = etEmailForget.text.toString().trim()
            val sPassword = etPassword.text.toString()
            if (email.isEmpty()) // return true if email is empty
            {
                etEmailForget.error = "Enter Email"
                etEmailForget.requestFocus()
            } else {
                auth.sendPasswordResetEmail(sPassword)
                    .addOnSuccessListener {
                        Toast.makeText(this, "Please check your Email", Toast.LENGTH_SHORT).show()
                    }

                    .addOnFailureListener {
                        Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
                    }

                    val intent = Intent(this, LoginActivity::class.java)
                     startActivity(intent)
            }
        }

        //I Remember password
        textViewBackToLogin.setOnClickListener() {
            //RegisterActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}