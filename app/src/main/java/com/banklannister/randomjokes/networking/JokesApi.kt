package com.banklannister.randomjokes.networking

import com.banklannister.randomjokes.data.JokesModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class JokesApi {

    companion object {
        const val BASE_URL = "https://icanhazdadjoke.com/"
    }


    private val httpClient = HttpClient(OkHttp) {
        install(Logging)
        install(ContentNegotiation) {
            json(
                json = Json {
                    ignoreUnknownKeys = true
                }
            )
        }

    }


    suspend fun getJokes(): JokesModel? {

        try {
            val response = httpClient.get(BASE_URL)
            return response.body<JokesModel?>()
        } catch (e: Exception) {
            return null
        }
    }
}