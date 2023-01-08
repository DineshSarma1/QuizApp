package com.dinesh.quizappassignment7.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dinesh.quizappassignment7.data.Quiz
import com.dinesh.quizappassignment7.repository.QuizRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(
    private val repository: QuizRepository
) : ViewModel(){

    private val _data: MutableLiveData<List<Quiz>> = MutableLiveData()
    val data: LiveData<List<Quiz>> = _data

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            _data.postValue(repository.getQuizList())
        }
    }

    fun resetDatabase(newList: MutableList<Quiz>) {
        viewModelScope.launch(Dispatchers.IO) {
            _data.postValue(newList)
        }
    }

    fun saveUserAnswer(quiz: Quiz) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertQuiz(quiz)
        }
    }
}