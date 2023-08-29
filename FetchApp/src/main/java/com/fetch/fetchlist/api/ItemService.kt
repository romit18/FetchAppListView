package com.fetch.fetchlist.api

import com.fetch.fetchlist.dto.Item
import retrofit2.http.GET

interface ItemService {
    @GET("hiring.json")
    suspend fun getItems(): List<Item>
}