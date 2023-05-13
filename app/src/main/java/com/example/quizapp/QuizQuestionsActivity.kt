package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class QuizQuestionsActivity : AppCompatActivity() {

    private var questionsList : List<Question>? = null

    private var tvQuestion : TextView? = null
    private var image : ImageView? = null
    private var optionsList : List<TextView>? = null
    private var progressBar : ProgressBar? = null
    private var tvProgress : TextView? = null
    private var btnSubmit : Button? = null
    private var currentQuestion : Question? = null
    private var questionCounter = 0 //question counter
    private var optionSelected : Int? = null //var to hold the selected option index
    private var score = 0 //initial quiz score
    private var isQuestionAnswered = false //flag to check if question has been answered

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        questionsList = Constants.getQuestions().shuffled()

        tvQuestion = findViewById(R.id.tv_question)
        image = findViewById(R.id.img)
        optionsList = listOf( //initializing the options list for the four options
            findViewById(R.id.tv_option_1),
            findViewById(R.id.tv_option_2),
            findViewById(R.id.tv_option_3),
            findViewById(R.id.tv_option_4)
        )
        progressBar = findViewById(R.id.progress_bar)
        tvProgress = findViewById(R.id.tv_progress)
        btnSubmit = findViewById(R.id.btn_submit)
        progressBar?.max = questionsList!!.size

        getQuestion() //get the first question

        //set a different background for a clicked option and grabbing its index
        optionsList!!.forEachIndexed { index, list ->
            list.setOnClickListener { tv ->
                toggleOptionsBackground(tv, index)
            }
        }
//
        btnSubmit?.setOnClickListener { btn ->
            if (questionCounter >= questionsList!!.size){ //if all the questions have been answered
                val intent = Intent(this, ScorePageActivity::class.java)
                val bundle = Bundle()
                //pass the score and player name to the next activity
                bundle.putInt(Constants.PLAYER_SCORE, score)
                bundle.putInt(Constants.NO_OF_QUESTIONS, questionsList!!.size)
                bundle.putString(Constants.PLAYER_NAME, getIntent().getStringExtra(Constants.PLAYER_NAME))
                intent.putExtras(bundle)
                startActivity(intent)
                finish()
            } else if (btn.tag == "check"){ //will execute if the current question has not been answered
                if (optionSelected == null){ //if no option has been selected
                    Toast.makeText(this, "Select an option", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                } else if (optionsList!![optionSelected!!].text == currentQuestion!!.answer){ //if the correct option was chosen
                    optionsList!![optionSelected!!].setBackgroundResource(R.drawable.tv_bg_correct)
                    score++ //increment score by one
                } else{
                    //set the background for wrong option selected
                    optionsList!![optionSelected!!].setBackgroundResource(R.drawable.tv_bg_wrong)
                    for (option in optionsList!!) { //find correct option and set background
                        if (option.text == currentQuestion!!.answer){
                            option.setBackgroundResource(R.drawable.tv_bg_correct)
                            break
                        }
                    }
                }
                isQuestionAnswered = true
                questionCounter++
                if (questionCounter >= questionsList!!.size) btnSubmit?.text = "Finish" //if it is the last question
                else btnSubmit?.text = "Next"
                btn.tag = "next" //makes the button go to the next question when clicked again
            } else {
                getQuestion() //get next question
            }
        }
    }

    private fun getQuestion(){
        btnSubmit?.text = "Submit"
        optionSelected = null
        isQuestionAnswered = false
        btnSubmit?.tag = "check"

        optionsList!!.forEach { it.setBackgroundResource(R.drawable.tv_bg) } //reset the background of all textview
        currentQuestion = questionsList!![questionCounter]
        tvQuestion?.text = currentQuestion!!.question
        image?.setImageResource(currentQuestion!!.image)
        for (i in optionsList!!.indices){ //assigning the options to their corresponding option list textview
            optionsList!![i].text = currentQuestion!!.options[i]
        }
        progressBar?.progress = questionCounter + 1
        tvProgress?.text = "${progressBar?.progress}/${questionsList!!.size}"
    }

    private fun toggleOptionsBackground(option : View, index : Int){
        if(!isQuestionAnswered) { //if the current question has not been answered
            //resetting the background in case another had been selected before
            optionsList!!.forEach { it.setBackgroundResource(R.drawable.tv_bg) }
            option.setBackgroundResource(R.drawable.tv_bg_clicked) //set the background for the clicked option
            optionSelected = index //get the index of the clicked option
        }
    }
}