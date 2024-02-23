package mx.com.mvtech.kosmoschallenge.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import mx.com.mvtech.kosmoschallenge.domain.models.CharacterModel
import mx.com.mvtech.kosmoschallenge.ui.designsystem.CustomLoader
import mx.com.mvtech.kosmoschallenge.ui.designsystem.DefaultTopAppBar
import mx.com.mvtech.kosmoschallenge.ui.designsystem.EmptyResults
import mx.com.mvtech.kosmoschallenge.ui.theme.KosmosChallengeTheme

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
){
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val context = LocalContext.current

    HomeScreenContent(
        isLoading = uiState.isLoading,
        characters = uiState.characters
    )
}

@Composable
fun HomeScreenContent(
    isLoading: Boolean,
    characters: List<CharacterModel> = emptyList()
){
    val scope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            DefaultTopAppBar(
                title = "Personajes"
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            if(isLoading){
                CustomLoader()
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {

                if(characters.isNotEmpty()){
                    /*CharactersList(
                        news = characters,
                        onItemClick = { news ->
                            onNewItemClick(news)
                        }
                    )*/
                }else{
                    EmptyResults(
                        message = "RESULTADOS NO ENCONTRADOS"
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun HomeScreenContentPreview(){
    KosmosChallengeTheme {
        HomeScreenContent(
            isLoading = true
        )
    }
}