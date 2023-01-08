package com.dinesh.quizappassignment7.util

import com.dinesh.quizappassignment7.data.AnswerModel

interface CheckClickInterface {
    fun onCheckBoxChecked(answerModel: AnswerModel)
    fun onCheckBoxUnChecked(answerModel: AnswerModel)
}