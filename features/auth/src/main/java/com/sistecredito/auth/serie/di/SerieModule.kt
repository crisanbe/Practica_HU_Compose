package com.sistecredito.auth.serie.di



import com.sistecredito.auth.serie.data.remote.SerieApi
import com.sistecredito.auth.serie.data.repository.SerieRepositoryImpl
import com.sistecredito.auth.serie.domain.repository.SerieRepository
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
object SerieModule {

    @Provides
    @Singleton
    fun provideServiceApi(): SerieApi {
        return Retrofit.Builder()
            .baseUrl(Constants.URL_SERIE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SerieApi::class.java)
    }

    @Provides
    @Singleton
    fun provideServiceRepository(api: SerieApi): SerieRepository {
        return SerieRepositoryImpl(api)
    }

}