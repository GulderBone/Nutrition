package com.gulderbone.data.repository

import com.gulderbone.data.repository.mapper.ProductStateMapper
import com.gulderbone.data.service.ProductService
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val productService: ProductService,
    private val productStateMapper: ProductStateMapper,
) {

    suspend fun getProductByBarcode(barcode: String): Product =
        productService.getProductByBarcode(barcode)
            .let(productStateMapper::from)
}

data class Product(
    private val name: String,
    private val tags: List<String>,
)

