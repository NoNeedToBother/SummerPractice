package com.example.summerpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var clickButton: Button? = null
    private var nameInput: EditText? = null
    private var heightInput: EditText? = null
    private var weightInput: EditText? = null
    private var ageInput: EditText? = null
    private var answer: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nameInput = findViewById(R.id.name_input)
        heightInput = findViewById(R.id.height_input)
        weightInput = findViewById(R.id.weight_input)
        ageInput = findViewById(R.id.age_input)
        clickButton = findViewById(R.id.button)
        answer = findViewById(R.id.answer)
        clickButton?.setOnClickListener {
            if (validate()) {
                setResult()
            } else {
                setIncorrect()
            }
        }
    }

    private fun setIncorrect(){
        answer?.text = "Данные введены некорректно"
        answer?.visibility = View.VISIBLE
    }

    private fun validate() : Boolean{
        val nameValue = nameInput?.text.toString()
        val heightValue = heightInput?.text.toString()
        val weightValue = weightInput?.text.toString()
        val ageValue = ageInput?.text.toString()

        if (nameValue.isEmpty() || heightValue.isEmpty() ||
            weightValue.isEmpty() || ageValue.isEmpty()) {
            return false
        } else if (nameValue.length > 50 ||
            heightValue.toInt() !in 1..249 ||
            ageValue.toInt() !in 1..149 ||
            !(weightValue.toDouble() > 0 && weightValue.toDouble() < 250)
        ) {
            return false
        }
        return true
    }

    private fun setResult() {
        val res : Int
        val name = nameInput?.text.toString()
        val height = heightInput?.text.toString().toInt()
        val weight = weightInput?.text.toString().toDouble()
        val age = ageInput?.text.toString().toInt()
        res = (name.length * 0.9 + height * 0.75 + weight * 0.8 + age * 0.9).toInt()
        when (res % 5){
            0 -> answer?.text = "Вам определённо повезёт"
            1 -> answer?.text = "Вам может повезти"
            2 -> answer?.text = "Ваша удача нейтральна"
            3 -> answer?.text = "Вам может не повезти"
            4 -> answer?.text = "Вам определённо не повезёт"
        }
        answer?.visibility = View.VISIBLE

    }
}