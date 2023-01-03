package com.alan.kotlinjson

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ServiceGenerator {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com/ercanduman/VisualizeRestaurants/master/app/src/main/assets/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(ApiService::class.java)
    //val call = service.getData()

}