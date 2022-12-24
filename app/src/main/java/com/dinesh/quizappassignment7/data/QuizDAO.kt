package com.dinesh.quizappassignment7.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface QuizDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuizQuestions(quizList : MutableList<Quiz>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuiz(quiz: Quiz)

    @Query("SELECT * FROM quiz")
    suspend fun getQuizList(): MutableList<Quiz>

    @Query("SELECT * FROM quiz WHERE id= :id")
    suspend fun getQuiz(id: Int): Quiz

}