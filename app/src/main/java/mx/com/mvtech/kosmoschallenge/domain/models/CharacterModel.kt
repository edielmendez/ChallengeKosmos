package mx.com.mvtech.kosmoschallenge.domain.models

data class CharacterModel(
    val id: Int,
    val name: String,
    val status: String,
    val image: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: String,
    val location: String
)

/*
@SerializedName("id"       ) var id       : Int?              = null,
  @SerializedName("name"     ) var name     : String?           = null,
  @SerializedName("status"   ) var status   : String?           = null,
  @SerializedName("species"  ) var species  : String?           = null,
  @SerializedName("type"     ) var type     : String?           = null,
  @SerializedName("gender"   ) var gender   : String?           = null,
  @SerializedName("origin"   ) var origin   : Origin?           = Origin(),
  @SerializedName("location" ) var location : Location?         = Location(),
  @SerializedName("image"    ) var image    : String?           = null,
  @SerializedName("episode"  ) var episode  : ArrayList<String> = arrayListOf(),
  @SerializedName("url"      ) var url      : String?           = null,
  @SerializedName("created"  ) var created  : String?           = null
 */