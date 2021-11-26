package com.sistecredito.auth.practice.di



import com.sistecredito.auth.character.data.repository.ServiceRepositoryImpl
import com.sistecredito.auth.practice.data.remote.CustomerApi
import com.sistecredito.auth.practice.data.repository.CustomerRepositoryImpl
import com.sistecredito.auth.practice.domain.repository.CustomerRepository
import com.sistecredito.shared.commons.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CustomerModule {

    @Provides
    @Singleton
    fun provideServiceApi(): CustomerApi {
        return Retrofit.Builder()
            .baseUrl(Constants.URL_PRACTICE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CustomerApi::class.java)
    }

    @Provides
    @Singleton
    fun provideServiceRepository(api: CustomerApi): CustomerRepository{
        return CustomerRepositoryImpl(api)
    }

}