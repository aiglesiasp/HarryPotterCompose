package com.ipa.dev.harrypottercompose.di.remote

import com.ipa.dev.harrypottercompose.framework.remote.api.CharacterApiService
import com.ipa.dev.harrypottercompose.framework.remote.api.SpellsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    private val BASE_URL = "https://hp-api.onrender.com"

    @Provides
    fun providesJson(): Json = Json {
        ignoreUnknownKeys = true
    }

    @Provides
    fun providesRetrofit(json: Json): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    @Provides
    fun providesCharacterService(retrofit: Retrofit): CharacterApiService {
        return retrofit.create<CharacterApiService>()
    }

    @Provides
    fun providesSpellsService(retrofit: Retrofit): SpellsApiService {
        return retrofit.create<SpellsApiService>()
    }
}