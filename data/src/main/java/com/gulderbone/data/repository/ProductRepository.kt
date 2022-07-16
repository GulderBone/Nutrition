package com.gulderbone.data.repository

import com.gulderbone.data.model.ProductStateResponse
import com.gulderbone.data.service.ProductService
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val productService: ProductService,
) {

    suspend fun getProductByBarcode(
        barcode: String,
    ): Product = from(productService.getProductByBarcode(barcode))

    private fun from(productStateResponse: ProductStateResponse): Product =
        Product(
            name = productStateResponse.product.productName,
            tags = productStateResponse.product.categoriesTags,
        )

}

data class Product(
    private val name: String,
    private val tags: List<String>,
)

