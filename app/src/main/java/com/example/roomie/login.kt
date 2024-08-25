package com.example.roomie


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class login : AppCompatActivity() {
    private lateinit var login_id: EditText
    private lateinit var password: EditText
    private lateinit var loginButton: Button
    private lateinit var forgotPassword: TextView
    private lateinit var sign_up: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        login_id = findViewById(R.id.loginID)
        password = findViewById(R.id.login_password)
        loginButton = findViewById(R.id.loginBtn)
        sign_up = findViewById(R.id.signupinput)
        sign_up.setOnClickListener {
            val intent = Intent(this, signup::class.java)
            startActivity(intent)
        }
        forgotPassword = findViewById(R.id.forgetPassword)
        loginButton.setOnClickListener {
            val id = login_id.text.toString()
            val password = password.text.toString()
            if (id.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter your credentials", Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()

                // Start the InquiryQuestions activity
                val intent = Intent(this, inquiryQuestion::class.java)
                startActivity(intent)
            }
        }

    }
}

