package com.techyourchance.dagger2course.screens.viewmodel

import androidx.lifecycle.*
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import com.techyourchance.dagger2course.questions.Question
import kotlinx.coroutines.launch
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider

class MyViewModel2 @Inject constructor(
        private val fetchQuestionsUseCase: FetchQuestionsUseCase
): ViewModel() {

    private val _questions = MutableLiveData<List<Question>>()
    val question : LiveData<List<Question>> = _questions



}