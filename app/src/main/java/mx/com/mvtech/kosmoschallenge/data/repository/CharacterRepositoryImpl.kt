package mx.com.mvtech.kosmoschallenge.data.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import mx.com.mvtech.kosmoschallenge.data.common.models.ServiceResult
import mx.com.mvtech.kosmoschallenge.data.datasource.CharacterRemoteDataSource
import mx.com.mvtech.kosmoschallenge.di.network.DefaultDispatcher
import mx.com.mvtech.kosmoschallenge.domain.models.CharacterModel
import mx.com.mvtech.kosmoschallenge.domain.repository.CharacterRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepositoryImpl @Inject constructor (
    private val dataSource: CharacterRemoteDataSource,
    @DefaultDispatcher private val dispatcher: CoroutineDispatcher
): CharacterRepository {
    override fun fetchCharacters(): Flow<ServiceResult<List<CharacterModel>>> = flow {
        emit(dataSource.fetchCharacters())
    }.flowOn(dispatcher)
}