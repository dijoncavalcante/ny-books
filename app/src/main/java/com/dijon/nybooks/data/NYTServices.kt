package com.dijon.nybooks.data

import retrofit2.Call
import retrofit2.http.GET


interface NYTServices {

    @GET("users/{user}/repos")
    fun listRepos()  : Call<List<>>
}