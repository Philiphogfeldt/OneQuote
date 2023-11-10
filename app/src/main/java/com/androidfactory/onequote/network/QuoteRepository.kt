package com.androidfactory.onequote.network

import com.androidfactory.onequote.AppState
import retrofit2.Response
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val quoteService: QuoteService
){

    suspend fun getQuoteOfTheDay(): Response<AppState.Quote> {
        return quoteService.getQuoteOfTheDay()
    }
}