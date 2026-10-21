package com.example.utsproject2026.model

import com.google.gson.annotations.SerializedName

data class Review(
    @field:SerializedName("rating") val rating: Int,
    @field:SerializedName("comment") val comment: String,
    @field:SerializedName("date") val date: String,
    @field:SerializedName("reviewerName") val reviewerName: String,
    @field:SerializedName("reviewerEmail") val reviewerEmail: String
)
