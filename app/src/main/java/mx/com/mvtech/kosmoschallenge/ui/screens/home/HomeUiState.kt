package mx.com.mvtech.kosmoschallenge.ui.screens.home

import mx.com.mvtech.kosmoschallenge.domain.models.CharacterModel

data class HomeUiState(
    val isLoading: Boolean = false,
    val characters: List<CharacterModel> = emptyList()
)