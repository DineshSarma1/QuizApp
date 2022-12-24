package com.dinesh.quizappassignment7.data

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface QuizRepository {
    suspend fun insertQuizQuestions(quizList : MutableList<Quiz>)
    suspend fun insertQuiz(quiz: Quiz)
    suspend fun getQuizList(): MutableList<Quiz>
    suspend fun resetQuestionSet()
}