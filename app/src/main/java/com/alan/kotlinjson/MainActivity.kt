package com.alan.kotlinjson

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alan.kotlinjson.api.model.ApiResponse
import com.alan.kotlinjson.api.model.Restaurant
import com.alan.kotlinjson.databinding.ActivityMainBinding
import com.alan.kotlinjson.ui.main.adapter.RestaurantAdapter
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
                        setupRecyclerView(it.restaurants)
                        for (restaurant: Restaurant in it.restaurants) {
                            println("restaurantData: $restaurant")
                        }

                    }
                }
            }

            override fun onFailure(call: retrofit2.Call<ApiResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    private val restaurantAdapter = RestaurantAdapter()

    private fun setupRecyclerView(restaurants: List<Restaurant>) {
        // set restaurantData to Adapter
        restaurantAdapter.submitList(restaurants)

        // initialize RecyclerView
        binding.restaurantList.apply {
            setHasFixedSize(true)
            adapter = restaurantAdapter
        }
    }
}
