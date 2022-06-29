package com.example.responsimws


import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET(".")
    fun getPosts(): Call<ArrayList<PostResponse>>
}