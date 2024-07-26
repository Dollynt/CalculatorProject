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

        createListeners()
    }

    private fun createListeners(){
        binding.sumButton.setOnClickListener{ operation(option = 0) }
        binding.subButton.setOnClickListener{ operation(option = 1) }
        binding.multButton.setOnClickListener{ operation(option = 2) }
        binding.divButton.setOnClickListener{ operation(option = 3) }
    }

    private fun operation(option: Int){
        val number1 = binding.editTextNumber1.text.toString().toDoubleOrNull() ?: 0.0
        val number2 = binding.editTextNumber2.text.toString().toDoubleOrNull() ?: 0.0

        val result = when(option){
            0 -> number1 + number2
            1 -> number1 - number2
            2 -> number1 * number2
            3 -> if (number2 != 0.0){
                number1 / number2
            } else {
                "Division by zero"
            }
            else -> {}
        }

        binding.result.text = result.toString()
    }
}

