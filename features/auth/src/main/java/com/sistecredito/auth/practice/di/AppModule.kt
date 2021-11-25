package com.sistecredito.auth.practice.di


import com.sistecredito.auth.login.data.repository.LoginRepositoryImpl
import com.sistecredito.auth.login.domain.repository.LoginRepository
import com.sistecredito.auth.practice.data.remote.ListaClienteApi
import com.sistecredito.auth.practice.data.repository.ListaClienteRepositoryImpl
import com.sistecredito.auth.practice.domain.repository.ListaClienteRepository
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
object ListaClienteModule {

    @Provides
    @Singleton
    fun provideHeaders(): Map<String, String> = CustomHeader.headers

    @Provides
    @Singleton
    fun provideLoginRepository(): ListaClienteRepository{
        return ListaClienteRepositoryImpl(
            ServiceBuilder.createService(
            serviceType = ListaClienteApi::class.java,
            Constants.URL_PRACTICE,
            headers = provideHeaders()
        ))
    }


}