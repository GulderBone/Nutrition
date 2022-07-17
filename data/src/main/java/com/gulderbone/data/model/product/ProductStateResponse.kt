package com.gulderbone.data.model.product

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductStateResponse(
    val code: String,
    val product: ProductResponse,
)
