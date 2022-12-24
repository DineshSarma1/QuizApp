package com.dinesh.quizappassignment7.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dinesh.quizappassignment7.data.Quiz
import com.dinesh.quizappassignment7.data.QuizRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserAnswerViewModel @Inject constructor(
    private val repository: QuizRepository
): ViewModel() {

    fun saveUserAnswer(quiz: Quiz) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertQuiz(quiz)
        }
    }
}