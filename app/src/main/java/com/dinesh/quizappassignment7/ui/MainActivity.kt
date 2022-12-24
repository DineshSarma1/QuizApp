package com.dinesh.quizappassignment7.ui

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.dinesh.quizappassignment7.R
import com.dinesh.quizappassignment7.constants.Constant.PREF_NAME
import com.dinesh.quizappassignment7.data.QuizFakeData
import com.dinesh.quizappassignment7.database.QuizDB
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initQuizData()


    }

    private fun initQuizData() {
        val initialQuestions = QuizFakeData.getQuizQuestions()
        val quizDAO = QuizDB(this).getQuizDAO()

        MainScope().launch {
            quizDAO.insertQuizQuestions(initialQuestions)
        }
    }

}