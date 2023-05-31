package com.example.newretrofitapp

import com.example.newretrofitapp.models.RegisterRequestData
import com.example.newretrofitapp.models.RegisterResponseData
import com.example.newretrofitapp.models.TaskRequestData
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface TodoApi {


    @POST("/api/register")
    suspend fun signUp(@Body body: RegisterRequestData): Response<RegisterResponseData>


    @POST("/api/tasks")
    suspend fun createTask(
        @Body body: TaskRequestData, @Header("Authorization") token: String
    ): Response<String>
}