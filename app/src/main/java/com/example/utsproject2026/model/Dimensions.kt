package com.example.utsproject2026.model

import com.google.gson.annotations.SerializedName

data class Dimensions(
    @field:SerializedName("width") val width: Double,
    @field:SerializedName("height") val height: Double,
    @field:SerializedName("depth") val depth: Double
)
