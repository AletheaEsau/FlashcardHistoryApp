package com.example.flashcardapp

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ReviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        val questions = intent.getStringArrayExtra("Nelson Mandela was the president in 1994")
        val answers = intent.getBooleanArrayExtra("True")
        val container = findViewById<LinearLayout>(R.id.reviewList)

        if (questions != null && answers != null) {
            for (i in questions.indices) {
                val questionText = TextView(this).apply {
                    text = "${i + 1}. ${questions[i]}"
                    textSize = 18f
                    setTextColor(resources.getColor(android.R.color.black))
                }

                val answerText = TextView(this).apply {
                    text = "Answer: ${if (answers[i]) "True" else "False"}\n"
                    textSize = 16f
                    setTextColor(resources.getColor(android.R.color.darker_gray))
                }

                container.addView(questionText)
                container.addView(answerText)
            }
        }
    }
}
