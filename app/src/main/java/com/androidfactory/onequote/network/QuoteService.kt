package com.androidfactory.onequote.network

import com.androidfactory.onequote.AppState
import retrofit2.Response
import retrofit2.http.GET

interface QuoteService {

    //base url https://zenquotes.io/api/

    @GET("today")
    suspend fun getQuoteOfTheDay(): Response<AppState.Quote>
}