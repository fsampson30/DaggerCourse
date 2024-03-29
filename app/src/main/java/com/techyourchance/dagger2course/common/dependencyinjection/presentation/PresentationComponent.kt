package com.techyourchance.dagger2course.common.dependencyinjection.presentation

import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailsActivity
import com.techyourchance.dagger2course.screens.questionslist.QuestionsListActivity
import com.techyourchance.dagger2course.screens.viewmodel.ViewModelActivity
import dagger.Subcomponent

@PresentationScope
@Subcomponent(modules = [PresentationModule::class,ViewModelModule::class])
interface PresentationComponent {

    fun inject(activity: QuestionDetailsActivity)
    fun inject(activity: QuestionsListActivity)
    fun inject(viewModelActivity: ViewModelActivity)
}