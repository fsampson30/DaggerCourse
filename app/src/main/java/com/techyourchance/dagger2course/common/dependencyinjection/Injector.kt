package com.techyourchance.dagger2course.common.dependencyinjection

import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailsActivity
import com.techyourchance.dagger2course.screens.questionslist.QuestionsListActivity

class Injector(private val compositionRoot: PresentationCompositionRoot) {

    fun inject(activity: QuestionDetailsActivity) {
        activity.screensNavigator = compositionRoot.screensNavigator
        activity.dialogsNavigator = compositionRoot.dialogsNavigator
        activity.fetchQuestionDetailsUseCase = compositionRoot.fetchQuestionDetailsUseCase
        activity.viewMvcFactory = compositionRoot.viewMvcFactory
    }

    fun inject(activity: QuestionsListActivity) {
        activity.screensNavigator = compositionRoot.screensNavigator
        activity.dialogsNavigator = compositionRoot.dialogsNavigator
        activity.fetchQuestionsUseCase = compositionRoot.fetchQuestionsUseCase
        activity.viewMvcFactory = compositionRoot.viewMvcFactory
    }
}