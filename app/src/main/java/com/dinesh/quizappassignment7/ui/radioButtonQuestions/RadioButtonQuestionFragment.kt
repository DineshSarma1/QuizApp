package com.dinesh.quizappassignment7.ui.radioButtonQuestions

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.dinesh.quizappassignment7.R
import com.dinesh.quizappassignment7.data.Quiz
import com.google.gson.Gson

class RadioButtonQuestionFragment : Fragment(R.layout.fragment_radio_button_question) {
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

        //initializing recycler view
        val recyclerView = view.findViewById<RecyclerView>(R.id.optionsRecyclerView)
        val adapter = RBQuestionAdapter(quiz.options)
        recyclerView.adapter = adapter
    }

    companion object {

        @JvmStatic
        fun newInstance(quiz: String) = RadioButtonQuestionFragment().apply {
            arguments = Bundle().apply {
                putString("quiz", quiz)
            }
        }
    }
}