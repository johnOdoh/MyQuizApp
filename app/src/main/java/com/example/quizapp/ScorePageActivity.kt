package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ScorePageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score_page)

        val playerName : TextView? = findViewById(R.id.tv_name)
        val score : TextView? = findViewById(R.id.tv_score)
        val btnRestart : Button = findViewById(R.id.btn_restart)

        playerName?.text = intent.extras?.getString("playerName")
        score?.text = intent.extras?.getString("score")
        btnRestart.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}