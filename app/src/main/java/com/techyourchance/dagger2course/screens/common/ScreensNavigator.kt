package com.techyourchance.dagger2course.screens.common

import android.app.Activity
import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailsActivity
import com.techyourchance.dagger2course.screens.viewmodel.ViewModelActivity

class ScreensNavigator(private val activity: Activity) {

    fun toQuestionDetails(questionId: String){
        QuestionDetailsActivity.start(activity,questionId)
    }

    fun toViewModel(){
        ViewModelActivity.start(activity)
    }

    fun navigateBack(){
        activity.onBackPressed()
    }
}