package com.example.flashcardapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.*

class FlashcardActivity : AppCompatActivity() {

    private val questions = arrayOf(
        "Nelson Mandela was the president in 1994",
        "World War II ended in 1945",
        "The Great Wall of China was built in one year",
        "The moon landing was in 1969",
        "The Berlin Wall fell in 1999"
    )

    private val answers = arrayOf(true, true, false, true, false)

    private var index = 0
    private var score = 0

    private lateinit var questionText: TextView
    private lateinit var feedbackText: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashcard)

        questionText = findViewById(R.id.questionText)
        feedbackText = findViewById(R.id.feedbackText)
        trueButton = findViewById(R.id.trueButton)
        falseButton = findViewById(R.id.falseButton)
        nextButton = findViewById(R.id.nextButton)

        setQuestion()

        trueButton.setOnClickListener { checkAnswer(true) }
        falseButton.setOnClickListener { checkAnswer(false) }
        nextButton.setOnClickListener {
            index++
            if (index < questions.size) {
                setQuestion()
            } else {
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("score", score)
                intent.putExtra("questions", questions)
                intent.putExtra("answers", answers)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun setQuestion() {
        questionText.text = questions[index]
        feedbackText.text = ""
        trueButton.isEnabled = true
        falseButton.isEnabled = true
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correct = answers[index] == userAnswer
        if (correct) {
            feedbackText.text = "Correct!"
            score++
        } else {
            feedbackText.text = "Incorrect"
        }
        trueButton.isEnabled = false
        falseButton.isEnabled = false
    }
}
