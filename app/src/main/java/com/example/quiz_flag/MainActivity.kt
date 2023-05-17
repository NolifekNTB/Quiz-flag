package com.example.quiz_flag

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var rounds = 1
    val Flag_list = mutableListOf("Poland", "Germany", "USA")
    var correct = Flag_list[0]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1 = findViewById<Button>(R.id.btnFirst)
        val btn2 = findViewById<Button>(R.id.btnSecond)
        val btn3 = findViewById<Button>(R.id.btnThird)
        val btn4 = findViewById<Button>(R.id.btnFourth)

        btn1.setOnClickListener { correctCheck(btn1) }
        btn2.setOnClickListener { correctCheck(btn2) }
        btn3.setOnClickListener { correctCheck(btn3) }
        btn4.setOnClickListener { correctCheck(btn4) }
    }

    private fun correctCheck(btn: Button) {
        if (btn.text == correct) {
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
            rounds++
            updateRound()
        } else {
            Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateRound() {
        val ivFlag = findViewById<ImageView>(R.id.ivFlag)
        when (rounds) {
            1 -> {
                ivFlag.setImageResource(R.drawable.poland)
                correct = Flag_list[0]
            }
            2 -> {
                ivFlag.setImageResource(R.drawable.germany)
                correct = Flag_list[1]
            }
            3 -> {
                ivFlag.setImageResource(R.drawable.usa)
                correct = Flag_list[2]
            }
        }
    }
}
