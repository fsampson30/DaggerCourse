package com.techyourchance.dagger2course.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.common.dependencyinjection.*
import com.techyourchance.dagger2course.common.dependencyinjection.activity.ActivityModule
import com.techyourchance.dagger2course.common.dependencyinjection.activity.DaggerActivityComponent
import com.techyourchance.dagger2course.common.dependencyinjection.presentation.DaggerPresentationComponent
import com.techyourchance.dagger2course.common.dependencyinjection.presentation.PresentationModule

open class BaseActivity: AppCompatActivity() {

    private val appCompositionRoot get() =  (application as MyApplication).appComponent

    private val activityComponent by lazy {
        DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this, appCompositionRoot))
                .build()
    }

    private val presentationComponent by lazy {
        DaggerPresentationComponent.builder()
                .activityComponent(activityComponent)
                .presentationModule(PresentationModule())
                .build()
    }

   protected val injector get() = presentationComponent


}