package com.example.internshiptask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.internshiptask.databinding.ActivityMainBinding
import com.example.internshiptask.databinding.ActivitySignInBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding
    private val firebaseAuth:FirebaseAuth=FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.buttonSignIn.setOnClickListener { v->
            val email:String = binding.signInEmailEt.text.toString()
            val password:String = binding.signInPasswordET.text.toString()

            if(email.isNotEmpty() && password.isNotEmpty()){
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if(it.isSuccessful){
                        Snackbar.make(v,"Successfully Login",Snackbar.LENGTH_SHORT).show()
                        startActivity(Intent(this,MainActivity::class.java))
                        finish()
                    }
                    else{
                        Snackbar.make(v,it.exception?.message.toString(),Snackbar.LENGTH_SHORT).show()
                    }
                }
            }
            else{
                Snackbar.make(v,"Empty fields are not allowed",Snackbar.LENGTH_SHORT).show()
            }
        }

        binding.tvForgotPassword.setOnClickListener {
            startActivity(Intent(this,ForgotPasswordActivity::class.java))
        }

        binding.tvSignUp.setOnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        if(firebaseAuth.currentUser!=null){
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}