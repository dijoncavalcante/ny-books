package com.dijon.nybooks.data

import com.dijon.nybooks.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface NYTServices {

    @GET("lists.json")
    fun getBooks(
        @Query("api-key") apiKey: String = "YUWYGmCDkvGwkhjU6KZfKLe5icx2Dj5l",
        @Query("list") list: String = "hardcover-fiction"


    ): Call<BookBodyResponse>
}