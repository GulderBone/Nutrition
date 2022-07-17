package com.gulderbone.data.repository.mapper

import com.gulderbone.data.model.ProductStateResponse
import com.gulderbone.data.repository.Product
import javax.inject.Inject

class ProductStateMapper @Inject constructor() {

    fun from(productStateResponse: ProductStateResponse): Product = with(productStateResponse) {
        Product(
            name = product.productName,
            tags = product.categoriesTags,
        )
    }
}