package com.example.newretrofitapp.models

import com.google.gson.annotations.SerializedName

data class TaskRequestData(
    @SerializedName("category_id")
    val categoryId: Int,
    val description: String,
    val task: String
)