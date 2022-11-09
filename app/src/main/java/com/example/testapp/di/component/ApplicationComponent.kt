package com.example.testapp.di.component

import android.app.Application
import com.example.testapp.TestApplication
import com.example.testapp.data.local.db.DatabaseService
import com.example.testapp.data.remote.NetworkService
import com.example.testapp.di.module.ApplicationModule
import com.example.testapp.utils.NetWorkUtility
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(app: TestApplication)

    fun getApplication(): Application

    fun getNetworkService(): NetworkService

    fun getDatabaseService(): DatabaseService

    fun getNetworkUtility() : NetWorkUtility
}