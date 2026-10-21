package com.example.utsproject2026.retrofit

import com.example.utsproject2026.respone.ProductResponse
import retrofit2.Call

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("products")
    fun getProducts(
        @Query("limit") limit: Int = 25
    ): Call<ProductResponse>
}