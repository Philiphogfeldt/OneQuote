package com.androidfactory.onequote

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.androidfactory.onequote.ui.theme.Purple

@Composable
fun AllQuotesScreen(
    quotes: List<AppState.Quote>,
    onFavoriteClicked: (AppState.Quote) -> Unit,
    viewModel: MainActivityViewModel = viewModel(),
    onFetchAllQuotesClicked: () -> Unit = { viewModel.fetchAllQuotes() }
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(quotes) { quote ->
                QuoteItem(quote, onFavoriteClicked)
            }
        }

        Button(
            onClick = { onFetchAllQuotesClicked() },
            modifier = Modifier.padding(20.dp)
        ) {
            Text("Get All Quotes")
        }
    }
}

@Composable
fun QuoteItem(quote: AppState.Quote, onFavoriteClicked: (AppState.Quote) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp, vertical = 8.dp)
            .background(color = Purple)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = quote.displayText,
                color = Color.White,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = quote.author,
                color = Color.White
            )
            // Fixa Favoknapp
        }
    }
}
