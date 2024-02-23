package mx.com.mvtech.kosmoschallenge.data.api

import mx.com.mvtech.kosmoschallenge.data.api.response.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterAPI {
    @GET("character/")
    suspend fun fetchCharacters(
        @Query("page") page: Int = 1
    ): Response<CharacterResponse>
}