package com.example.onelab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.onelab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnStartIntent.setOnClickListener {
            startIntent()

        }
    }

    private fun startIntent(){
        val intent = Intent(this, SecondaryActivity::class.java)
        startActivity(intent)

    }
}