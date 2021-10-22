package com.sistecredito.auth.character.di

import com.sistecredito.auth.character.data.remote.ServiceApi
import com.sistecredito.auth.character.data.repository.ServiceRepositoryImpl
import com.sistecredito.auth.character.domain.repository.ServiceRepository
import com.sistecredito.shared.commons.Constants.URL_TEST
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideServiceApi(): ServiceApi {
        return Retrofit.Builder()
            .baseUrl(URL_TEST)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ServiceApi::class.java)
    }

    @Provides
    @Singleton
    fun provideServiceRepository(api: ServiceApi): ServiceRepository {
        return ServiceRepositoryImpl(api)
    }
}