package com.example.internshiptask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.internshiptask.databinding.ActivityForgotPasswordBinding
import com.example.internshiptask.databinding.ActivitySignInBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class ForgotPasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityForgotPasswordBinding
    private val firebaseAuth:FirebaseAuth= FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.sendLinkButton.setOnClickListener { v ->
            val email:String= binding.forgotPasswordEmailEt.text.toString()

            if(email.isNotEmpty()){
              firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener {
                  if(it.isSuccessful){
                      Snackbar.make(v,"Reset your password, link is shared to your email",Snackbar.LENGTH_SHORT).show()
                      startActivity(Intent(this,SignInActivity::class.java))
                      finish()
                  }
                  else{
                      Snackbar.make(v,it.exception?.message.toString(),Snackbar.LENGTH_SHORT).show()
                  }
              }
            }
            else{
                Snackbar.make(v,"Please enter the email address",Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}