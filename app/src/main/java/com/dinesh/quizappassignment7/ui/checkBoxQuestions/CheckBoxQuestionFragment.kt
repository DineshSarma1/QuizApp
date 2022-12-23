package com.dinesh.quizappassignment7.ui.checkBoxQuestions

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.dinesh.quizappassignment7.R
import com.dinesh.quizappassignment7.data.Quiz
import com.dinesh.quizappassignment7.database.QuizDB
import com.dinesh.quizappassignment7.util.CheckClickInterface
import com.google.gson.Gson
import kotlinx.coroutines.runBlocking

class CheckBoxQuestionFragment : Fragment(R.layout.fragment_check_box_question),
    CheckClickInterface {

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
        val adapter = CBQuestionAdapter(quiz.options, this)
        recyclerView.adapter = adapter
    }

    companion object {

        @JvmStatic
        fun newInstance(quiz: String) = CheckBoxQuestionFragment().apply {
            arguments = Bundle().apply {
                putString("quiz", quiz)
            }
        }
    }

    private var checkedOptions: ArrayList<Int> = arrayListOf()

    override fun onCheckBoxChecked(optionsSelected: Int) {
        checkedOptions.add(optionsSelected)
    }

    override fun onCheckBoxUnChecked(optionsSelected: Int) {
        checkedOptions.remove(optionsSelected)
    }

    override fun onPause() {
        super.onPause()
        var answer = ""
        checkedOptions.sort()
        checkedOptions.forEach { option ->
            answer += when (option) {
                0 -> "a"
                1 -> "b"
                2 -> "c"
                4 -> "d"
                else -> ""
            }
        }
        val quizDAO = QuizDB(requireContext()).getQuizDAO()

        //update the answer parameter of quiz object
        quiz.userAnswer = answer
        if (answer.isNotEmpty()) {
            runBlocking {
                quizDAO.insertQuiz(quiz)
            }
        }
    }

}