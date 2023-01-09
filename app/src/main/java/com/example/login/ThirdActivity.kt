package com.example.login

import android.app.Activity
import android.os.Bundle
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.login.databinding.ActivityThreeBinding

class ThirdActivity: AppCompatActivity() {
    lateinit var binding: ActivityThreeBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}