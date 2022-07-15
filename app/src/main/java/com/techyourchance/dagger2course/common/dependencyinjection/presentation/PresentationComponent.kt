package com.techyourchance.dagger2course.common.dependencyinjection.presentation

import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailsActivity
import com.techyourchance.dagger2course.screens.questionslist.QuestionsListActivity
import dagger.Subcomponent

@PresentationScope
@Subcomponent()
interface PresentationComponent {

    fun inject(activity: QuestionDetailsActivity)
    fun inject(activity: QuestionsListActivity)
}