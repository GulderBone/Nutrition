package com.gulderbone.data.service

import com.gulderbone.data.model.product.ProductStateResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {

    @GET("product/{barcode}")
    suspend fun getProductByBarcode(
        @Path("barcode") barcode: String,
    ): ProductStateResponse
}
