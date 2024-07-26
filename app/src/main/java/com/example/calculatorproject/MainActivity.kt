package com.example.calculatorproject

import android.content.ContentValues.TAG
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.calculatorproject.databinding.ActivityMainBinding
import android.util.Log

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createListeners()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "o método onStart() foi invocado!")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "O método onRestart() foi invocado!")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "O método onResume() foi invocado!")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "O método onPause() foi invocado!")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "O método onStop() foi invocado!")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "O método onDestroy() foi invocado!")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("editTextNumber1", binding.editTextNumber1.text.toString())
        outState.putString("editTextNumber2", binding.editTextNumber2.text.toString())
        outState.putString("result", binding.result.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        binding.editTextNumber1.setText(savedInstanceState.getString("editTextNumber1"))
        binding.editTextNumber2.setText(savedInstanceState.getString("editTextNumber2"))
        binding.result.text = savedInstanceState.getString("result")
    }


    private fun createListeners(){
        binding.sumButton.setOnClickListener{ operation( 0) }
        binding.subButton.setOnClickListener{ operation( 1) }
        binding.multButton.setOnClickListener{ operation( 2) }
        binding.divButton.setOnClickListener{ operation( 3) }
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

