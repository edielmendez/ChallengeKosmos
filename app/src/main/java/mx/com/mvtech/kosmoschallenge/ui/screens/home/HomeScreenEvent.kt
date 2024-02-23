package mx.com.mvtech.kosmoschallenge.ui.screens.home

sealed interface HomeScreenEvent{
    object FetchCharacters: HomeScreenEvent
}

/*
sealed interface HomeEvent{
    object FetchNews: HomeEvent
    data class Search(val word: String): HomeEvent
    object ResetList: HomeEvent
}
 */