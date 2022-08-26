package com.gulderbone.data.di

import com.gulderbone.data.repository.ProductRepositoryImpl
import com.gulderbone.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {

    @Binds
    abstract fun bindProductRepository(
        productRepository: ProductRepositoryImpl,
    ): ProductRepository
}