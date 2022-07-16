package com.gulderbone.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductResponse(
    @Json(name = "product_name") val productName: String,
    @Json(name = "categories_tags") val categoriesTags: List<String>,
)