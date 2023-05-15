package com.jh2108.retrogsonapi

import retrofit2.Response
import retrofit2.http.GET

interface ArticlesApi {
    @GET("everything?q=starship&pageSize=5&page=1&apiKey=XXXXXXXXXXXXXXXXXXXXXXXX")
    suspend fun getData() : Response<Root>
}
