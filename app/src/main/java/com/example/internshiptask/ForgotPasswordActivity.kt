package com.example.internshiptask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.internshiptask.databinding.ActivityForgotPasswordBinding
import com.example.internshiptask.databinding.ActivitySignInBinding

class ForgotPasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

    }
}