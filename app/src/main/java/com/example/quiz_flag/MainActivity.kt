package com.example.quiz_flag

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var rounds = 1
    val Flag_list = mutableListOf("Poland", "Germany", "USA")
    var correct = Flag_list[0]
    var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1 = findViewById<Button>(R.id.btnFirst)
        val btn2 = findViewById<Button>(R.id.btnSecond)
        val btn3 = findViewById<Button>(R.id.btnThird)
        val btn4 = findViewById<Button>(R.id.btnFourth)

        btn1.setOnClickListener { ifCorrectCheck(btn1) }
        btn2.setOnClickListener { ifCorrectCheck(btn2) }
        btn3.setOnClickListener { ifCorrectCheck(btn3) }
        btn4.setOnClickListener { ifCorrectCheck(btn4) }
    }

    private fun ifCorrectCheck(btn: Button) {
        if (btn.text == correct) {
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
            rounds++
            score++
            updateRound()
        } else {
            Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
            rounds++
            updateRound()
        }
    }

    private fun updateRound() {
        val ivFlag = findViewById<ImageView>(R.id.ivFlag)
        when (rounds) {
            1 -> {
                ivFlag.setImageResource(R.drawable.poland)
                correct = Flag_list[0]
                setButtonsAnswers()
            }

            2 -> {
                ivFlag.setImageResource(R.drawable.germany)
                correct = Flag_list[1]
                setButtonsAnswers()
            }

            3 -> {
                ivFlag.setImageResource(R.drawable.usa)
                correct = Flag_list[2]
                setButtonsAnswers()
            }
            4 -> {
                startActivity(Intent(this, EndLogo::class.java)
                    .putExtra("SCORE", score))
            }
        }
    }
    private fun setButtonsAnswers(){
        val listToSet = randomAnswers()

        findViewById<Button>(R.id.btnFirst).text = listToSet[0]
        findViewById<Button>(R.id.btnSecond).text = listToSet[1]
        findViewById<Button>(R.id.btnThird).text = listToSet[2]
        findViewById<Button>(R.id.btnFourth).text = listToSet[3]
    }

    private fun randomAnswers(): MutableList<String>{
        val country = mutableListOf("Poland", "Russia", "Usa", "China", "Mongolia", "Norway", "Sweden", "Ukraine", "Iceland")
        val answers = mutableListOf("", "", "", "")

        //Define correct answer
        val excludeIndex = Random.nextInt(0, 4)
        answers[excludeIndex] = correct
        country.removeAt(excludeIndex)

        for (i in 0..3){
            if (i == excludeIndex){
                continue
            }
            val randomString = country[Random.nextInt(country.size-1)]
            answers[i] = randomString
            country.remove(randomString)
        }
        return answers
    }
}
