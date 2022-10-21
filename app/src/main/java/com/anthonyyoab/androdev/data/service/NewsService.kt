package com.anthonyyoab.androdev.data.service

import com.anthonyyoab.androdev.ui.model.NewsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsService {
    @GET("/animals/rand")
    fun getRandomNews(): Single<NewsResponse>

    @GET("/animals/rand/{number}")
    fun getRandomNewes(@Path("number") number: Int): Single<List<NewsResponse>>
}