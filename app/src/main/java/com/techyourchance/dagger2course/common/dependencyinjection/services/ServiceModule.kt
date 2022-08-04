package com.techyourchance.dagger2course.common.dependencyinjection.services

import android.app.Service
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck

@Module
@DisableInstallInCheck
class ServiceModule(
        val service: Service
) {

    @Provides
    fun context(): Context = service
}