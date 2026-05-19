package com.example.hastakalashop.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hastakalashop.R
import com.example.hastakalashop.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
