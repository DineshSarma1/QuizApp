package com.dinesh.quizappassignment7.ui.checkBoxQuestions

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dinesh.quizappassignment7.R
import com.dinesh.quizappassignment7.data.Quiz
import com.dinesh.quizappassignment7.databinding.FragmentCheckBoxQuestionBinding
import com.dinesh.quizappassignment7.ui.UserAnswerViewModel
import com.dinesh.quizappassignment7.util.CheckClickInterface
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CheckBoxQuestionFragment : Fragment(R.layout.fragment_check_box_question), CheckClickInterface {

    private lateinit var quiz: Quiz
    private lateinit var viewModel: UserAnswerViewModel
    private lateinit var binding: FragmentCheckBoxQuestionBinding
    private var checkedOptions: ArrayList<Int> = arrayListOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArgumentsData()

        initSetup(view)
    }

    private fun getArgumentsData() {
        arguments?.let {
            quiz = Gson().fromJson(it.getString("quiz"), Quiz::class.java)
        }
    }

    private fun initSetup(view: View) {
        binding = FragmentCheckBoxQuestionBinding.bind(view)
        viewModel = ViewModelProvider(requireActivity())[UserAnswerViewModel::class.java]

        binding.questionTextView.text = quiz.question

        //initializing recycler view
        val adapter = CBQuestionAdapter(quiz.options, this)
        binding.optionsRecyclerView.adapter = adapter
    }

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

        //update the answer parameter of quiz object
        quiz.userAnswer = answer
        if (answer.isNotEmpty()) {
            viewModel.saveUserAnswer(quiz)
        }

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