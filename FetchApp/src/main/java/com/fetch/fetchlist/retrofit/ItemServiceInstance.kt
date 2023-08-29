package com.fetch.fetchlist.retrofit

import com.fetch.fetchlist.api.ItemService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ItemServiceInstance {
    private const val FETCH_BASE_URL = "https://fetch-hiring.s3.amazonaws.com/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(FETCH_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val itemService: ItemService by lazy {
        retrofit.create(ItemService::class.java)
    }
}