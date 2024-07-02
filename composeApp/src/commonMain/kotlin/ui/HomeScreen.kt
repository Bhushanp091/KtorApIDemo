package ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText


class Greeting {
    private val client = HttpClient()

    suspend fun greeting(): String {
        val response = client.get("https://dog.ceo/api/breeds/image/random")
        return response.body()
    }
}

