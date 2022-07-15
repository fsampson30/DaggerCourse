package com.techyourchance.dagger2course.screens.common.viewsmvc

import android.view.LayoutInflater
import android.view.ViewGroup
import com.techyourchance.dagger2course.screens.common.imageloader.ImageLoader
import com.techyourchance.dagger2course.screens.questiondetails.QuestionsDetailsMvc
import com.techyourchance.dagger2course.screens.questionslist.QuestionsListMvc
import javax.inject.Inject

class ViewMvcFactory @Inject constructor(
        private val layoutInflater: LayoutInflater,
        private val imageLoader: ImageLoader
) {

    fun newQuestionsListViewMvc(parent: ViewGroup?) : QuestionsListMvc{
        return QuestionsListMvc(layoutInflater, parent)
    }

    fun newQuestionsDetailsViewMvc(parent: ViewGroup?) : QuestionsDetailsMvc{
        return QuestionsDetailsMvc(layoutInflater, imageLoader, parent)
    }
}