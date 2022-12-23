package com.dinesh.quizappassignment7.data

import com.dinesh.quizappassignment7.database.QuizDatabase

class QuizRepositoryImpl(
    private val db: QuizDatabase
) : QuizRepository{

    private val quizDao = db.quizDAO

    override suspend fun insertQuizQuestions(quizList: MutableList<Quiz>) {
        quizDao.insertQuizQuestions(quizList)
    }

    override suspend fun insertQuiz(quiz: Quiz) {
        quizDao.insertQuiz(quiz)
    }

    override suspend fun getQuizList(): MutableList<Quiz> {
        return quizDao.getQuizList()
    }

}