package com.dinesh.quizappassignment7.ui.checkBoxQuestions

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dinesh.quizappassignment7.R
import com.dinesh.quizappassignment7.data.AnswerModel
import com.dinesh.quizappassignment7.data.Quiz
import com.dinesh.quizappassignment7.databinding.FragmentCheckBoxQuestionBinding
import com.dinesh.quizappassignment7.viewModel.QuizViewModel
import com.dinesh.quizappassignment7.util.CheckClickInterface
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CheckBoxQuestionFragment : Fragment(R.layout.fragment_check_box_question), CheckClickInterface {

    private lateinit var quiz: Quiz
    private lateinit var viewModel: QuizViewModel
    private lateinit var binding: FragmentCheckBoxQuestionBinding
    private var checkedOptions: ArrayList<AnswerModel> = arrayListOf()

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
        viewModel = ViewModelProvider(requireActivity())[QuizViewModel::class.java]

        binding.questionTextView.text = quiz.question

        //initializing recycler view
        val adapter = CBQuestionAdapter(quiz.options, this)
        binding.optionsRecyclerView.adapter = adapter
    }

    override fun onCheckBoxChecked(answerModel: AnswerModel) {
        checkedOptions.add(answerModel)
    }

    override fun onCheckBoxUnChecked(answerModel: AnswerModel) {
        checkedOptions.remove(answerModel)
    }

    override fun onPause() {
        super.onPause()
        var answer = ""
        var answerDesc = ""
        checkedOptions.sortedBy { it.option }
        checkedOptions.forEach { answerModel ->
            answer += when (answerModel.option) {
                0 -> "a"
                1 -> "b"
                2 -> "c"
                3 -> "d"
                else -> ""
            }
            answerDesc += answerModel.description+"\n"
        }

        //update the answer parameter of quiz object
        quiz.userAnswer = answer
        quiz.userAnswerDesc = answerDesc
        viewModel.saveUserAnswer(quiz)
        Log.v("CheckBoxQuestionFragment", "inserted data : $quiz")
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