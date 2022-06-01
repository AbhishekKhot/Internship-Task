package com.example.internshiptask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.internshiptask.databinding.ActivitySignInBinding
import com.example.internshiptask.databinding.ActivitySignUpBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private val firebaseAuth:FirebaseAuth= FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.buttonSignUp.setOnClickListener { v ->
            val email:String=binding.signUpEmailEt.text.toString()
            val password:String=binding.signUpPassET.text.toString()

            if(email.isNotEmpty() && password.isNotEmpty()){
                firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
                    if(it.isSuccessful){
                        Snackbar.make(v,"Registered successfully",Snackbar.LENGTH_SHORT).show()
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

        binding.tvSignIn.setOnClickListener {
            startActivity(Intent(this,SignInActivity::class.java))
            finish()
        }
    }
}