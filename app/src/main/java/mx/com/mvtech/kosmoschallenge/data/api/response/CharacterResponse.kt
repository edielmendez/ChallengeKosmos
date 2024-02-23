package mx.com.mvtech.kosmoschallenge.data.api.response

import com.google.gson.annotations.SerializedName
import mx.com.mvtech.kosmoschallenge.domain.models.CharacterModel

data class CharacterResponse(
    @SerializedName("info"    ) var info    : InfoDto?              = InfoDto(),
    @SerializedName("results" ) var results : List<CharacterDto> = emptyList()
)

data class InfoDto (
    @SerializedName("count" ) var count : Int?    = null,
    @SerializedName("pages" ) var pages : Long?   = null,
    @SerializedName("next"  ) var next  : String? = null,
    @SerializedName("prev"  ) var prev  : String? = null
)

data class CharacterDto (
    @SerializedName("id"       ) var id       : Int?              = null,
    @SerializedName("name"     ) var name     : String?           = null,
    @SerializedName("status"   ) var status   : String?           = null,
    @SerializedName("species"  ) var species  : String?           = null,
    @SerializedName("type"     ) var type     : String?           = null,
    @SerializedName("gender"   ) var gender   : String?           = null,
    @SerializedName("origin"   ) var origin   : OriginDto?        = OriginDto(),
    @SerializedName("location" ) var location : LocationDto?      = LocationDto(),
    @SerializedName("image"    ) var image    : String?           = null,
    @SerializedName("episode"  ) var episode  : ArrayList<String> = arrayListOf(),
    @SerializedName("url"      ) var url      : String?           = null,
    @SerializedName("created"  ) var created  : String?           = null
){
    fun toCharacterModel() = CharacterModel(
        id = id ?: 0,
        name = name ?: "unknow",
        status = status ?: "",
        image = image ?: "",
        species = species ?: "",
        type = type ?: "",
        gender = gender ?: "",
        origin = origin?.name ?: "",
        location = location?.name ?: ""
    )
}

data class OriginDto (
    @SerializedName("name" ) var name : String? = null,
    @SerializedName("url"  ) var url  : String? = null
)

data class LocationDto (
    @SerializedName("name" ) var name : String? = null,
    @SerializedName("url"  ) var url  : String? = null
)