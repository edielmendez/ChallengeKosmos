package mx.com.mvtech.kosmoschallenge.domain.repository

import kotlinx.coroutines.flow.Flow
import mx.com.mvtech.kosmoschallenge.data.common.models.ServiceResult
import mx.com.mvtech.kosmoschallenge.domain.models.CharacterModel

interface CharacterRepository {
    fun fetchCharacters(): Flow<ServiceResult<List<CharacterModel>>>
}