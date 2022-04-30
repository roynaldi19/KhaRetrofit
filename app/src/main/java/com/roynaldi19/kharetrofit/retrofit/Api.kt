package com.roynaldi19.kharetrofit.retrofit

import com.roynaldi19.kharetrofit.model.PostResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("posts")
    fun getPost(): Call<ArrayList<PostResponse>>
}