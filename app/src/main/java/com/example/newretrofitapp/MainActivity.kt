package com.example.newretrofitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.newretrofitapp.databinding.ActivityMainBinding
import com.example.newretrofitapp.models.RegisterRequestData
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    lateinit var api: TodoApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRetrofit()


        binding.btnSignUp.setOnClickListener {
            MainScope().launch {
                val response = api.signUp(RegisterRequestData(binding.etPhone.text.toString(), binding.etName.text.toString(), binding.etPassword.text.toString()))
                if (response.isSuccessful) {
                    Log.e("TTTT", response.body().toString())
                    Log.e("TTTT","Token: ${response.body()!!.payload.token}")
                } else {
                    Log.e("TTTT", response.errorBody().toString())
                }
            }
        }
    }

    private fun initRetrofit() {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC


        val okHttpClient = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()

        val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://todo.paydali.uz").client(okHttpClient).build()


        api = retrofit.create(TodoApi::class.java)
    }
}