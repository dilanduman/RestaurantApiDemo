package com.alan.kotlinjson

import com.alan.kotlinjson.api.model.ApiResponse
import retrofit2.http.GET

interface ApiService {

    @GET("sample_android.json")
    fun getData(): retrofit2.Call<ApiResponse>
}