package com.example.daggerhiltdemo.ui.about

import com.example.daggerhiltdemo.di.AboutUsFragmentName
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
class AboutUsFragmentModule {

    @Provides
    @AboutUsFragmentName
    fun provideAboutUsFragmentName() = "About us Fragment"

}