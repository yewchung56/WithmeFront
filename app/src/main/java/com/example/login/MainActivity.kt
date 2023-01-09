package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.example.login.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.loginclick.setOnClickListener {
            val id = binding.edid.text.toString()
            val pass = binding.edpassword.text.toString()
            if (id == "") {
                val nextIntent = Intent(this, SecondActivity::class.java)
                startActivity(nextIntent)
            }
            if(pass==""){
                val thirdIntent = Intent(this, ThirdActivity::class.java)
                startActivity(thirdIntent)
            }
        }
    }
}