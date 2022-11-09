package com.example.testapp.di.component

import com.example.testapp.di.ActivityScope
import com.example.testapp.di.module.ActivityModule
import com.example.testapp.ui.main.MainActivity
import dagger.Component

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {

    fun inject(activity: MainActivity)
}