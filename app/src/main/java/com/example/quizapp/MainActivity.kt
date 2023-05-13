package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart : Button = findViewById(R.id.btnStart)
        val nameText : EditText = findViewById(R.id.nameText)
        btnStart.setOnClickListener {
            if (nameText.text.isEmpty()) Toast.makeText(this, "Enter a Name", Toast.LENGTH_LONG).show()
            else{
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.PLAYER_NAME, nameText.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}