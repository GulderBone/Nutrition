package com.gulderbone.domain.feature.interactor

import com.gulderbone.domain.feature.model.Product
import com.gulderbone.domain.repository.ProductRepository
import javax.inject.Inject

class GetProductByBarcodeUseCase @Inject constructor(
    private val productRepository: ProductRepository,
) {

    suspend fun run(barcode: String): Product =
        productRepository.getProductByBarcode(barcode)
}