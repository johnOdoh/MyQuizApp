package com.example.quizapp

data class Question(
    val id : Int,
    val image : Int,
    val question : String,
    val options : List<String>,
    val answer : String
)

