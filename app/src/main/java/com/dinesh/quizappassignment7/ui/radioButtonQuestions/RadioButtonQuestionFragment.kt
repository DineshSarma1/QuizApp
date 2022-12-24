package com.dinesh.quizappassignment7.ui.radioButtonQuestions

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.dinesh.quizappassignment7.R
import com.dinesh.quizappassignment7.data.Quiz
import com.dinesh.quizappassignment7.database.QuizDB
import com.dinesh.quizappassignment7.databinding.FragmentCheckBoxQuestionBinding
import com.dinesh.quizappassignment7.databinding.FragmentRadioButtonQuestionBinding
import com.dinesh.quizappassignment7.ui.UserAnswerViewModel
import com.dinesh.quizappassignment7.util.RadioClickInterface
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
class RadioButtonQuestionFragment : Fragment(R.layout.fragment_radio_button_question), RadioClickInterface {
    private lateinit var quiz: Quiz
    private lateinit var viewModel: UserAnswerViewModel
    private lateinit var binding: FragmentRadioButtonQuestionBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArgumentsData()
        initSetup(view)
    }

    private fun initSetup(view: View) {
        binding = FragmentRadioButtonQuestionBinding.bind(view)
        viewModel = ViewModelProvider(requireActivity())[UserAnswerViewModel::class.java]

        binding.questionTextView.text = quiz.question

        //initializing recycler view
        val adapter = RBQuestionAdapter(quiz.options, this)
        binding.optionsRecyclerView.adapter = adapter
    }

    override fun onPause() {
        super.onPause()
        if (quiz.userAnswer!!.isNotEmpty()) {
            //inserting data to data base
            viewModel.saveUserAnswer(quiz)
        }
    }

    override fun onRadioButtonClicked(optionPosition: Int) {
        quiz.userAnswer = when(optionPosition) {
            0 -> "a"
            1 -> "b"
            2 -> "c"
            4 -> "d"
            else -> ""
        }
    }

    private fun getArgumentsData() {
        arguments?.let {
            quiz = Gson().fromJson(it.getString("quiz"), Quiz::class.java)
        }
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