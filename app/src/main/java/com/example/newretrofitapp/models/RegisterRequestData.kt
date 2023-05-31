package com.example.newretrofitapp.models

import com.google.gson.annotations.SerializedName

data class RegisterRequestData(
    val phone: String,
    val name: String,
    val password: String
)