package com.ipa.dev.harrypottercompose.di

import androidx.lifecycle.SavedStateHandle
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Named

@Module
@InstallIn(ViewModelComponent::class)
class ViewModelModule {

    @Provides
    @ViewModelScoped
    @Named("name")
    fun provideName(savedStateHandle: SavedStateHandle): String {
        return savedStateHandle.get<String>("name") ?: ""
    }
}