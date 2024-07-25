package com.example.calculatorproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.calculatorproject.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sumButton.setOnClickListener {
            val num1 = binding.editTextNumber1.text.toString().toDoubleOrNull()
            val num2 = binding.editTextNumber2.text.toString().toDoubleOrNull()

            if (num1 != null && num2 != null) {
                val sum = num1 + num2
                binding.result.text = sum.toString()
            }
        }

        binding.subButton.setOnClickListener {
            val num1 = binding.editTextNumber1.text.toString().toDoubleOrNull()
            val num2 = binding.editTextNumber2.text.toString().toDoubleOrNull()

            if (num1 != null && num2 != null) {
                val sub = num1 - num2
                binding.result.text = sub.toString()
            }
        }

        binding.multButton.setOnClickListener {
            val num1 = binding.editTextNumber1.text.toString().toDoubleOrNull()
            val num2 = binding.editTextNumber2.text.toString().toDoubleOrNull()

            if (num1 != null && num2 != null) {
                val mult = num1 * num2
                binding.result.text = mult.toString()
            }
        }

        binding.divButton.setOnClickListener {
            val num1 = binding.editTextNumber1.text.toString().toDoubleOrNull()
            val num2 = binding.editTextNumber2.text.toString().toDoubleOrNull()

            if (num1 != null && num2 != null) {
                if (num2 != 0.0) {
                    val div = num1 / num2
                    binding.result.text = div.toString()
                }
            }
        }
    }
}

