package mx.com.mvtech.kosmoschallenge.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import mx.com.mvtech.kosmoschallenge.data.common.models.ServiceResult
import mx.com.mvtech.kosmoschallenge.domain.repository.CharacterRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: CharacterRepository
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

    private fun fetchCharacters(){
        setLoading()
        viewModelScope.launch {
            repository
                .fetchCharacters()
                .catch {  }
                .collectLatest { serviceResult ->
                    when(serviceResult){
                        is ServiceResult.Success -> {
                            vmUiState.update {
                                it.copy(
                                    isLoading = false,
                                    characters = serviceResult.data
                                )
                            }
                        }
                        is ServiceResult.Error -> {

                        }
                    }
                }
        }
    }

    private fun setLoading(isLoading: Boolean = true){
        vmUiState.update {
            it.copy(isLoading = isLoading)
        }
    }
}