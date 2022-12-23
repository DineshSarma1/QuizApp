package com.dinesh.quizappassignment7.ui.radioButtonQuestions

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.dinesh.quizappassignment7.R
import com.dinesh.quizappassignment7.data.Quiz
import com.dinesh.quizappassignment7.database.QuizDB
import com.dinesh.quizappassignment7.util.RadioClickInterface
import com.google.gson.Gson
import kotlinx.coroutines.runBlocking

class RadioButtonQuestionFragment : Fragment(R.layout.fragment_radio_button_question), RadioClickInterface {
    private lateinit var quiz: Quiz

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

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
        val adapter = RBQuestionAdapter(quiz.options, this)
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

    override fun onRadioButtonClicked(optionPosition: Int) {
        val answer = when(optionPosition) {
            0 -> "a"
            1 -> "b"
            2 -> "c"
            4 -> "d"
            else -> ""
        }

        //update the answer parameter of quiz object
        quiz.userAnswer = answer

    }

    override fun onPause() {
        super.onPause()

        if (quiz.userAnswer!!.isNotEmpty()) {
            //inserting data to data base
            val quizDAO = QuizDB(requireContext()).getQuizDAO()
            runBlocking {
                quizDAO.insertQuiz(quiz)
            }
        }
    }
}