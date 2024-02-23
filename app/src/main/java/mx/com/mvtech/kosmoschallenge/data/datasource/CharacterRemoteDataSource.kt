package mx.com.mvtech.kosmoschallenge.data.datasource

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import mx.com.mvtech.kosmoschallenge.data.api.CharacterAPI
import mx.com.mvtech.kosmoschallenge.data.common.models.ServiceResult
import mx.com.mvtech.kosmoschallenge.di.network.DefaultDispatcher
import mx.com.mvtech.kosmoschallenge.domain.models.CharacterModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRemoteDataSource @Inject constructor(
    private val api: CharacterAPI,
    @DefaultDispatcher private val dispatcher: CoroutineDispatcher
) {
    suspend fun fetchCharacters(): ServiceResult<List<CharacterModel>> = withContext(dispatcher) {
        try {
            val response = api.fetchCharacters()
            if (response.isSuccessful) {
                ServiceResult.Success(response.body()?.results?.map { it.toCharacterModel() } ?: emptyList())
            }else{
               ServiceResult.Error(response.errorBody().toString())
            }
        } catch (e: Exception) {
            ServiceResult.Error(e.message ?: "")
        }
    }
}