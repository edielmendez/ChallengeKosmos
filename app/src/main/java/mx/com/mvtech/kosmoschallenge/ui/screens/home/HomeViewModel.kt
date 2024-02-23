package mx.com.mvtech.kosmoschallenge.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

): ViewModel(){
    private val vmUiState =
        MutableStateFlow(HomeUiState())

    val uiState = vmUiState.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        vmUiState.value
    )

    fun onEvent(event: HomeScreenEvent){
        when(event){
            is HomeScreenEvent.FetchCharacters -> {
                fetchCharacters()
            }
        }
    }

    fun fetchCharacters(){
        setLoading()
        viewModelScope.launch {
            delay(3000)
            vmUiState.update {
                it.copy(
                    isLoading = false,
                    characters = MockData.characters
                )
            }
        }
    }

    private fun setLoading(isLoading: Boolean = true){
        vmUiState.update {
            it.copy(isLoading = isLoading)
        }
    }
}