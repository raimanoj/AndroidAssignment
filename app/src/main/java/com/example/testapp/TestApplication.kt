package com.example.testapp

import android.app.Application
import com.example.testapp.di.component.ApplicationComponent
import com.example.testapp.di.component.DaggerApplicationComponent
import com.example.testapp.di.module.ApplicationModule

class TestApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }

}