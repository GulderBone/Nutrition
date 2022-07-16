package com.gulderbone.data.di

import com.gulderbone.data.service.ProductService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideMoshi(): Moshi =
        Moshi.Builder().build()

    @Provides
    fun provideProductService(

        moshi: Moshi,
    ): ProductService =
        Retrofit.Builder()
            .baseUrl("https://world.openfoodfacts.org/api/v2/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(ProductService::class.java)
}