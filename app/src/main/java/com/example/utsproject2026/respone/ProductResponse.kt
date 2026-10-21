package com.example.utsproject2026.respone


import com.google.gson.annotations.SerializedName
import com.example.utsproject2026.model.ProductItem

data class ProductResponse(
    @field:SerializedName("products")
    val products: List<ProductItem>,
    @field:SerializedName("total")
    val total: Int,
    @field:SerializedName("skip")
    val skip: Int,
    @field:SerializedName("limit")
    val limit: Int
)