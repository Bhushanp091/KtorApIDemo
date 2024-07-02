package Modules

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.http.ContentType.Application.Json
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val providehttpClientModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(json = Json { ignoreUnknownKeys = true }, contentType = ContentType.Any)
            }
        }
    }
}

//This module  creates HTTP Request
//Notes


//This defines a Koin module named providehttpClientModule. Koin is a dependency injection framework for Kotlin, and a module is a container that holds definitions of how to create and configure dependencies.
//single is function which like singlton
//httpclient created http request
//content negptiation allows httpclient to handle json, html ,xml format
//json ingnor... This is useful to prevent errors if the JSON response from the server contains fields that are not mapped to your data class.