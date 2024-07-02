package repository

import Model.ApiResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class NetworkRepository(private val httpClient: HttpClient) {

    fun getProductList(): Flow<NetWorkResult<ApiResponse?>> {
        return flow {

            emit(NetWorkResult.Loading(true))
            try {
                val response = httpClient.get("https://dummyjson.com/products").body<ApiResponse>()
                emit(NetWorkResult.Success(response))
            }catch (e:Exception){
               // emit(NetWorkResult.Error(e.message!!))

            }


        }
}


}