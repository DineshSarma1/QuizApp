package com.dinesh.quizappassignment7

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dinesh.quizappassignment7.constants.Constant.IS_DB_INITIALIZED
import com.dinesh.quizappassignment7.constants.Constant.PREF_NAME
import com.dinesh.quizappassignment7.data.QuizFakeData
import com.dinesh.quizappassignment7.database.QuizDB
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private val _TAG = MainActivity::class.simpleName
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPref = getSharedPreferences(PREF_NAME,0)

        //This will initialize quiz questions only once in the app
        if (!sharedPref.getBoolean(IS_DB_INITIALIZED, false)) {
            initQuizData()
        }else {
            Log.v(_TAG,"Quiz questions are already inserted")
        }

    }

    private fun initQuizData() {

        //manage shared pref
        val sharedPrefEdit = sharedPref.edit()
        sharedPrefEdit.putBoolean(IS_DB_INITIALIZED,true)
        sharedPrefEdit.apply()

        val initialQuestions = QuizFakeData.getQuizQuestions()
        val quizDAO = QuizDB(this).getQuizDAO()
        MainScope().launch {
            quizDAO.insertQuizQuestions(initialQuestions)
            Log.v(_TAG," Quiz questions are inserted!" + "\n size : "+quizDAO.getQuizList().size)

        }

    }

}