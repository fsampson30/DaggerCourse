package com.techyourchance.dagger2course.common.dependencyinjection.app

import com.techyourchance.dagger2course.common.dependencyinjection.activity.ActivityComponent
import com.techyourchance.dagger2course.common.dependencyinjection.activity.ActivityModule
import com.techyourchance.dagger2course.common.dependencyinjection.services.ServiceComponent
import com.techyourchance.dagger2course.common.dependencyinjection.services.ServiceModule
import dagger.Component

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {

    fun newActivityComponentBuilder() : ActivityComponent.Builder

    fun newServiceComponent(serviceModule: ServiceModule): ServiceComponent
}