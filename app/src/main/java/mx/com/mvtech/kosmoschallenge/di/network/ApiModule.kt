package mx.com.mvtech.kosmoschallenge.di.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mx.com.mvtech.kosmoschallenge.data.api.CharacterAPI
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Singleton
    @Provides
    fun provideCoverageAPI(retrofit: Retrofit): CharacterAPI =  retrofit.create(CharacterAPI::class.java)
}