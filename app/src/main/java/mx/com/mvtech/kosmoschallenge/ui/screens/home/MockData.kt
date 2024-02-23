package mx.com.mvtech.kosmoschallenge.ui.screens.home

import mx.com.mvtech.kosmoschallenge.domain.models.CharacterModel

object MockData {
    val characters = listOf(
        CharacterModel(
            id = 1,
            name = "Rick Sanchez",
            status = "Alive",
            image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            type = "",
            gender = "Male",
            origin = "Earth (C-137)",
            location = "Citadel of Ricks",
            species = "Human"
        ),
        CharacterModel(
            id = 1,
            name = "Rick Sanchez",
            status = "Alive",
            image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            type = "",
            gender = "Male",
            origin = "Earth (C-137)",
            location = "Citadel of Ricks",
            species = "Human"
        ),
        CharacterModel(
            id = 1,
            name = "Rick Sanchez",
            status = "Alive",
            image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            type = "",
            gender = "Male",
            origin = "Earth (C-137)",
            location = "Citadel of Ricks",
            species = "Human"
        )
    )
}

/*
"id":1,
         "name":"Rick Sanchez",
         "status":"Alive",
         "species":"Human",
         "type":"",
         "gender":"Male",
         "origin":{
            "name":"Earth (C-137)",
            "url":"https://rickandmortyapi.com/api/location/1"
         },
         "location":{
            "name":"Citadel of Ricks",
            "url":"https://rickandmortyapi.com/api/location/3"
         },
 */