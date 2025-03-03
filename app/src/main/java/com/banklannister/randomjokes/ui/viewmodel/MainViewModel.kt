package com.banklannister.randomjokes.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.banklannister.randomjokes.data.JokesModel
import com.banklannister.randomjokes.networking.JokesApi
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val jokeClient = JokesApi()
    val joke = mutableStateOf<JokesModel?>(null)


    fun getJokes() {
        viewModelScope.launch {
            joke.value = jokeClient.getJokes()
        }
    }
}