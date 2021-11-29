package com.sistecredito.auth.productos.di



import com.sistecredito.auth.productos.data.remote.ProductApi
import com.sistecredito.auth.productos.data.repository.ProductRepositoryImpl
import com.sistecredito.auth.productos.domain.repository.ProductRepository
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
object ProductModule {

    @Provides
    @Singleton
    fun provideServiceApi(): ProductApi {
        return Retrofit.Builder()
            .baseUrl(Constants.URL_PRODUCT)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductApi::class.java)
    }

    @Provides
    @Singleton
    fun provideServiceRepository(api: ProductApi): ProductRepository {
        return ProductRepositoryImpl(api)
    }

}