package com.gulderbone.data.repository

import com.gulderbone.domain.feature.model.Product
import com.gulderbone.data.repository.mapper.ProductStateMapper
import com.gulderbone.data.service.ProductService
import com.gulderbone.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productService: ProductService,
    private val productStateMapper: ProductStateMapper,
): ProductRepository {

    override suspend fun getProductByBarcode(barcode: String): Product =
        productService.getProductByBarcode(barcode)
            .let(productStateMapper::from)
}

