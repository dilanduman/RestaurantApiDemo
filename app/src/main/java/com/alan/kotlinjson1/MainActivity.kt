package com.alan.kotlinjson1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alan.kotlinjson1.api.model.ApiResponse
import com.alan.kotlinjson1.api.model.Restaurant
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var restaurantData: ArrayList<Restaurant>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()
    }

    private fun loadData() {
        val call = ServiceGenerator.service.getData()
        call.enqueue(object : retrofit2.Callback<ApiResponse> {
            override fun onResponse(
                call: retrofit2.Call<ApiResponse>,
                response: Response<ApiResponse>,
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        restaurantData = ArrayList(it.restaurants)


                        for (data: Restaurant in restaurantData!!) {
                            println(restaurantData)
                        }

                    }
                }
            }

            override fun onFailure(call: retrofit2.Call<ApiResponse>, t: Throwable) {
                t.printStackTrace()
            }


        })
    }

}