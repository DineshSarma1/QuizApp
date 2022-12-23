package com.dinesh.quizappassignment7.ui.checkBoxQuestions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import com.dinesh.quizappassignment7.R
import com.dinesh.quizappassignment7.data.Quiz
import com.google.gson.Gson

class CheckBoxQuestionFragment : Fragment(R.layout.fragment_check_box_question) {

    private lateinit var quiz: Quiz

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            quiz = Gson().fromJson(it.getString("quiz"), Quiz::class.java)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSetup(view)
    }

    private fun initSetup(view: View) {
        val questionTV = view.findViewById<TextView>(R.id.questionTextView)
        questionTV.text = quiz.question
    }

    companion object {

        @JvmStatic
        fun newInstance(quiz: String) = CheckBoxQuestionFragment().apply {
            arguments = Bundle().apply {
                putString("quiz", quiz)
            }
        }
    }
}