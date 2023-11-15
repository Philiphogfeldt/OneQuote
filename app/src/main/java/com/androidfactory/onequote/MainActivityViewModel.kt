package com.androidfactory.onequote

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidfactory.onequote.AppState.Navigation.Page
import com.androidfactory.onequote.network.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val quoteRepository: QuoteRepository
) : ViewModel() {

    private val _appState = MutableStateFlow(AppState.initial())
    val appState: StateFlow<AppState> = _appState.asStateFlow()


    fun selectPage(page: Page) {
        _appState.update {
            return@update it.copy(
                navigation = it.navigation.copy(
                    selectedPage = page
                )
            )
        }
    }

    fun fetchData() = viewModelScope.launch {

        val quoteOfTheDayResponse = quoteRepository.getQuoteOfTheDay()
        Log.d("Response", quoteOfTheDayResponse?.toString() ?: "Failed to fetch")
        _appState.update {
            return@update it.copy(
                quoteOfTheDay = AppState.Quote(
                    author = quoteOfTheDayResponse?.a ?: "",
                    displayText = quoteOfTheDayResponse?.q ?: "",
                    isFavorite = false
                )
            )
        }
    }

    fun fetchAllQuotes() = viewModelScope.launch {
        val networkQuotes = quoteRepository.getAllQuotes()
        val quotes = networkQuotes.map { networkQuote ->
            AppState.Quote(
                author = networkQuote.a,
                displayText = networkQuote.q,
                isFavorite = false
            )
        }
        _appState.update { currentState ->
            currentState.copy(allQuotes = quotes)
        }
    }

}