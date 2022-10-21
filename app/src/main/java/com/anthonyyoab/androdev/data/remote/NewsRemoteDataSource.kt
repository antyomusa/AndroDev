package com.anthonyyoab.androdev.data.remote

import com.anthonyyoab.androdev.data.service.NewsService
import com.anthonyyoab.androdev.ui.model.NewsResponse
import io.reactivex.Single

class NewsRemoteDataSource(private val newsService: NewsService) {
    fun getRandomNews(): Single<NewsResponse>{
        return newsService.getRandomNews()
    }

    fun getRandomNewes(number: Int): Single<List<NewsResponse>> {
        return newsService.getRandomNewes(number)
    }
}