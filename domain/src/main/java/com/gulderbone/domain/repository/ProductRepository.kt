package com.gulderbone.domain.repository

import com.gulderbone.domain.feature.model.Product

interface ProductRepository {

    suspend fun getProductByBarcode(barcode: String): Product
}