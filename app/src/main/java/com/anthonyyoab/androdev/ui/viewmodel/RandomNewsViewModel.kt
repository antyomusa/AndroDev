package com.anthonyyoab.androdev.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anthonyyoab.androdev.data.remote.NewsRemoteDataSource
import com.anthonyyoab.androdev.data.repository.NewsRepository
import com.anthonyyoab.androdev.data.service.NewsService
import com.anthonyyoab.androdev.retrofit.NewsRetrofit
import com.anthonyyoab.androdev.ui.model.NewsResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class RandomNewsViewModel: ViewModel() {
    private var randomNewsLiveData = MutableLiveData<NewsResponse>()
    private val compositeDisposable = CompositeDisposable()

    private var newsService: NewsService = NewsRetrofit.newsService
    private var newsRemoteDataSource: NewsRemoteDataSource = NewsRemoteDataSource(newsService)
    private var newsRepository: NewsRepository = NewsRepository(newsRemoteDataSource)

    fun getRandomNews(){
        compositeDisposable.add(
            newsRepository.getRandomNews()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<NewsResponse>(){
                    override fun onSuccess(t: NewsResponse) {
                        randomNewsLiveData.value = t
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }

                })
        )

    }

    fun getRandomNewsLiveData(): MutableLiveData<NewsResponse> = randomNewsLiveData

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }
}