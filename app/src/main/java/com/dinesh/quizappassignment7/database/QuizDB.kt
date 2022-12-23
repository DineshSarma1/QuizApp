package com.dinesh.quizappassignment7.database

import android.content.Context
import androidx.room.Room
import com.dinesh.quizappassignment7.constants.Constant
import com.dinesh.quizappassignment7.data.QuizDAO

class QuizDB(private val context: Context) {

    private var quizDatabase: QuizDatabase = Room.databaseBuilder(
        context,
        QuizDatabase::class.java,
        Constant.DB_NAME
    ).build()

    public fun getQuizDAO(): QuizDAO = quizDatabase.quizDAO
}