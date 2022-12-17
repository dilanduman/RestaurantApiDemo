package com.alan.kotlinjson1

import Restaurant
import com.alan.kotlinjson1.api.model.ApiResponse

import retrofit2.http.GET

interface ApiService {

    @GET("sample_android.json")
    fun getData(): retrofit2.Call<ApiResponse>
}