package com.ipa.dev.harrypottercompose.di.remote

import com.ipa.dev.harrypottercompose.data.remote.CharacterRemoteDataSource
import com.ipa.dev.harrypottercompose.data.remote.SpellsRemoteDataSource
import com.ipa.dev.harrypottercompose.framework.remote.CharacterRemoteDataSourceImpl
import com.ipa.dev.harrypottercompose.framework.remote.SpellsRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteModule {

    @Binds
    abstract fun bindCharacterRemoteDataSource(impl: CharacterRemoteDataSourceImpl): CharacterRemoteDataSource

    @Binds
    abstract fun bindSpellsRemoteDataSource(impl: SpellsRemoteDataSourceImpl): SpellsRemoteDataSource

}