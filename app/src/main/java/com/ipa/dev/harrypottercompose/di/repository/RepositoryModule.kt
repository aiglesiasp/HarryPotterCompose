package com.ipa.dev.harrypottercompose.di.repository

import com.ipa.dev.harrypottercompose.data.CharacterRepositoryImpl
import com.ipa.dev.harrypottercompose.data.SpellsRepositoryImpl
import com.ipa.dev.harrypottercompose.domain.CharacterRepository
import com.ipa.dev.harrypottercompose.domain.SpellsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindCharacterRepository(impl: CharacterRepositoryImpl): CharacterRepository

    @Binds
    abstract fun bindSpellsRepository(impl: SpellsRepositoryImpl): SpellsRepository

}