package com.anthonyyoab.androdev.data.repository

import com.anthonyyoab.androdev.data.remote.NewsRemoteDataSource
import com.anthonyyoab.androdev.ui.model.NewsResponse
import io.reactivex.Single

class NewsRepository(private val newsRemoteDataSource: NewsRemoteDataSource) {
     fun getRandomNews(): Single<NewsResponse>{
         return newsRemoteDataSource.getRandomNews()
     }

    fun getRandomListNewes(number: Int): Single<List<NewsResponse>>{
        return newsRemoteDataSource.getRandomNewes(number)
    }
}