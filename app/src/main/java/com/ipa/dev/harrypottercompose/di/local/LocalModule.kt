package com.ipa.dev.harrypottercompose.di.local

import com.ipa.dev.harrypottercompose.data.local.CharacterLocalDataSource
import com.ipa.dev.harrypottercompose.framework.local.CharacterLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalModule {
    @Binds
    abstract fun bindCharacterLocalDataSource(impl: CharacterLocalDataSourceImpl): CharacterLocalDataSource
}