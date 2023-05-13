package com.example.quizapp

object Constants {
    const val PLAYER_NAME : String = "player_name"
    const val PLAYER_SCORE : String = "player_score"
    const val NO_OF_QUESTIONS : String = "no_of_questions"

    fun getQuestions() : ArrayList<Question>{

        val questionsList = ArrayList<Question>()
        questionsList.add(
            Question(
                1,
                R.drawable.ic_flag_of_argentina,
                "Which Country's flag is this?",
                listOf("Argentina", "Vatican City", "Greenland", "Suriname").shuffled(),
                "Argentina"
            )
        )
        questionsList.add(
            Question(
                2,
                R.drawable.ic_flag_of_australia,
                "Which Country's flag is this?",
                listOf("United Kingdom", "Cuba", "New Zealand", "Australia").shuffled(),
                "Australia"
            )
        )
        questionsList.add(
            Question(
                3,
                R.drawable.ic_flag_of_belgium,
                "Which Country's flag is this?",
                listOf("Belgium", "Austria", "Senegal", "Netherlands").shuffled(),
                "Belgium"
            )
        )
        questionsList.add(
            Question(
                4,
                R.drawable.ic_flag_of_denmark,
                "Which Country's flag is this?",
                listOf("Finland", "Denmark", "Iceland", "Norway").shuffled(),
                "Denmark"
            )
        )
        questionsList.add(
            Question(
                5,
                R.drawable.ic_flag_of_brazil,
                "Which Country's flag is this?",
                listOf("Moldova", "Russia", "Brazil", "Honduras").shuffled(),
                "Brazil"
            )
        )
        questionsList.add(
            Question(
                6,
                R.drawable.ic_flag_of_fiji,
                "Which Country's flag is this?",
                listOf("Fiji", "Ukraine", "Estonia", "Thailand").shuffled(),
                "Fiji"
            )
        )
        questionsList.add(
            Question(
                7,
                R.drawable.ic_flag_of_germany,
                "Which Country's flag is this?",
                listOf("Jamaica", "Bosnia & Herzegovina", "Indonesia", "Germany").shuffled(),
                "Germany"
            )
        )
        questionsList.add(
            Question(
                8,
                R.drawable.ic_flag_of_india,
                "Which Country's flag is this?",
                listOf("India", "Saudi Arabia", "Qatar", "Pakistan").shuffled(),
                "India"
            )
        )
        questionsList.add(
            Question(
                9,
                R.drawable.ic_flag_of_kuwait,
                "Which Country's flag is this?",
                listOf("Mexico", "Kuwait", "Jordan", "Syria").shuffled(),
                "Kuwait"
            )
        )
        questionsList.add(
            Question(
                10,
                R.drawable.ic_flag_of_new_zealand,
                "Which Country's flag is this?",
                listOf("Australia", "United States", "New Zealand", "Dominican Republic").shuffled(),
                "New Zealand"
            )
        )
        return questionsList
    }
}