package com.example.onelab

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.onelab.databinding.ActivitySecondaryBinding


private const val TAG = "Secondary Activity"

class SecondaryActivity : AppCompatActivity() {

    companion object {
        private const val COUNTER = "counter"
    }

    private lateinit var binding: ActivitySecondaryBinding
    private var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondaryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "onCreate")

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(COUNTER)
            binding.tvConfChangesCounter.text = counter.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(COUNTER, ++counter)
        super.onSaveInstanceState(outState)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")

    }
}