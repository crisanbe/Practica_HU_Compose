package com.sistecredito.auth.loginTraining.di

import com.sistecredito.auth.loginTraining.data.remote.LoginTrainingApi
import com.sistecredito.auth.loginTraining.data.repository.LoginTrainingRepositoryImpl
import com.sistecredito.auth.loginTraining.domain.repository.LoginTrainigRepository
import com.sistecredito.network.ServiceBuilder
import com.sistecredito.shared.commons.Constants
import com.sistecredito.shared.commons.CustomHeader
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHeaders(): Map<String, String> = CustomHeader.headers

    @Provides
    @Singleton
    fun provideLoginTrainigRepository(): LoginTrainigRepository {
        return LoginTrainingRepositoryImpl(
            ServiceBuilder.createService(
                LoginTrainingApi::class.java,
                Constants.URL_SISTE,
                headers = provideHeaders()
            )
        )
    }
}