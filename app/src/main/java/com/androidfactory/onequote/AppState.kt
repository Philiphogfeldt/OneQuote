package com.androidfactory.onequote

import androidx.compose.ui.graphics.Color


data class AppState(
    val navigation: Navigation,
    val quoteOfTheDay: Quote,
    val allQuotes: List<Quote> = emptyList()
) {
    data class Quote(
        val displayText: String,
        val author: String,
        val isFavorite: Boolean
    )

    data class Navigation(
        val navItems: List<Page>,
        val selectedPage: Page
    ) {
        data class Page(val title: String, val color: Color)
    }

    companion object {
        fun initial(): AppState {
            val pages = buildList {
                add(Navigation.Page("All quotes", Color.Red))
                add(Navigation.Page("Daily quote", Color.Green))
                add(Navigation.Page("Favorites", Color.Blue))
            }
            return AppState(
                navigation = Navigation(
                    navItems = pages,
                    selectedPage = pages[1]
                ),
                quoteOfTheDay = Quote(
                    displayText = "No data, fetch",
                    author = "...",
                    isFavorite = true
                )
            )
        }
    }
}