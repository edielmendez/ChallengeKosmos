package mx.com.mvtech.kosmoschallenge.di.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mx.com.mvtech.kosmoschallenge.data.repository.CharacterRepositoryImpl
import mx.com.mvtech.kosmoschallenge.domain.repository.CharacterRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RespositoryModule {
    @Provides
    @Singleton
    fun provideCharacterRepository(characterRepositoryImpl: CharacterRepositoryImpl): CharacterRepository = characterRepositoryImpl
}