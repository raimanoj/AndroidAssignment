package com.example.testapp.di.module

import android.app.Application
import androidx.room.Room
import com.example.testapp.BuildConfig
import com.example.testapp.TestApplication
import com.example.testapp.data.local.db.DatabaseService
import com.example.testapp.data.remote.NetworkService
import com.example.testapp.data.remote.Networking
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: TestApplication) {

    @Provides
    @Singleton
    fun provideApplication(): Application = application

    @Provides
    @Singleton
    fun provideDatabaseService(): DatabaseService =
        Room.databaseBuilder(
            application, DatabaseService::class.java,
            "test_app.db"
        ).build()

    @Provides
    @Singleton
    fun provideNetworkService(): NetworkService =
        Networking.create(
            BuildConfig.BASE_URL
        )
}