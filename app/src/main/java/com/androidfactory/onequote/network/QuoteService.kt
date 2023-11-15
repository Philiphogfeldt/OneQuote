package com.androidfactory.onequote.network

import com.androidfactory.onequote.network.models.NetworkQuote
import retrofit2.Response
import retrofit2.http.GET

interface QuoteService {

    @GET("today")
    suspend fun getQuoteOfTheDay(): Response<List<NetworkQuote>>

    //get med "quotes" call för alla
    @GET("quotes")
    suspend fun getAllQuotes(): List<NetworkQuote>
}