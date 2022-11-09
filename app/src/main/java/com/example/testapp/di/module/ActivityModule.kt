package com.example.testapp.di.module

import android.app.Activity
import androidx.lifecycle.ViewModelProviders
import com.example.testapp.data.repository.MainRepository
import com.example.testapp.ui.main.MainActivity
import com.example.testapp.ui.main.MainViewModel
import com.example.testapp.utils.NetWorkUtility
import com.example.testapp.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    fun provideMainViewModel(
        mainRepository: MainRepository,
        netWorkUtility: NetWorkUtility
    ): MainViewModel = ViewModelProviders.of(
        activity as MainActivity,
        ViewModelProviderFactory(MainViewModel::class) {
            MainViewModel(mainRepository, netWorkUtility)
        }).get(MainViewModel::class.java)
}