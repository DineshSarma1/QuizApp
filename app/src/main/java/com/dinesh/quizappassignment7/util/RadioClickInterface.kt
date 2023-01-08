package com.dinesh.quizappassignment7.util

import com.dinesh.quizappassignment7.data.Quiz

interface RadioClickInterface {
    fun onRadioButtonClicked(optionPosition: Int, userAnswerDesc: String)
}