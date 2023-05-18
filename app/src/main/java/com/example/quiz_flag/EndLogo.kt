package com.example.quiz_flag

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class EndLogo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_logo)

        val score = intent.getIntExtra("SCORE", 0)

        findViewById<TextView>(R.id.tvEnd).text = "You finally end the game!"
        findViewById<TextView>(R.id.tvScore).text = "You get $score point"
    }
}