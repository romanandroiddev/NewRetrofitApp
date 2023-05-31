package com.example.newretrofitapp.models

data class RegisterResponseData(
    val success: Boolean, val code: Int, val message: String, val payload: RegisterPayloadData
)

data class RegisterPayloadData(
    val name: String, val phone: String, val token: String
)
