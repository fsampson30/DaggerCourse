package com.techyourchance.dagger2course.questions

import com.techyourchance.dagger2course.Constants
import com.techyourchance.dagger2course.networking.StackoverflowApi
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FetchQuestionDetailsUseCase(private val retrofit: Retrofit) {


    private val stackoverflowApi: StackoverflowApi = retrofit.create(StackoverflowApi::class.java)

    sealed class Result() {
        class Success(val question: QuestionWithBody) : Result()
        object Failure : Result()
    }

    suspend fun fetchQuestionDetails(questionId: String): FetchQuestionDetailsUseCase.Result {
        return withContext(Dispatchers.IO) {
            try {
                val response = stackoverflowApi.questionDetails(questionId)
                if (response.isSuccessful && response.body() != null) {
                    return@withContext FetchQuestionDetailsUseCase.Result.Success(response.body()!!.question)
                } else {
                    return@withContext FetchQuestionDetailsUseCase.Result.Failure
                }
            } catch (t: Throwable) {
                if (t !is CancellationException) {
                    return@withContext FetchQuestionDetailsUseCase.Result.Failure
                } else {
                    throw t
                }
            }
        }
    }
}