package com.example.calculatorproject

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.calculatorproject.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val txtUsername: TextView = findViewById(R.id.txtLabel)
        val btnSubmit: Button = findViewById(R.id.btnAction)

        btnSubmit.setOnClickListener(){
            txtUsername.text = getString(R.string.label_changed)
        }
    }
}

