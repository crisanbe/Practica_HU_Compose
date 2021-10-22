package com.sistecredito.auth.login.di

import com.sistecredito.auth.character.data.remote.ServiceApi
import com.sistecredito.auth.character.data.repository.ServiceRepositoryImpl
import com.sistecredito.auth.character.domain.repository.ServiceRepository
import com.sistecredito.auth.login.data.remote.LoginApi
import com.sistecredito.auth.login.data.remote.ServiceBuilder
import com.sistecredito.auth.login.data.repository.LoginRepositoryImpl
import com.sistecredito.auth.login.domain.model.Login
import com.sistecredito.auth.login.domain.repository.LoginRepository
import com.sistecredito.shared.commons.Constants
import com.sistecredito.shared.commons.CustomHeader
import dagger.Binds
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
    fun provideLoginRepository(): LoginRepository {
        return LoginRepositoryImpl(ServiceBuilder.createService(
            serviceType = LoginApi::class.java,
            Constants.URL_SISTE,
            headers = provideHeaders()
        ))
    }


}