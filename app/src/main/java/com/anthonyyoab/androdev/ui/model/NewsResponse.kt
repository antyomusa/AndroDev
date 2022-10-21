package com.anthonyyoab.androdev.ui.model

import com.google.gson.annotations.SerializedName

/*
{
    "name": "Verreaux's Eagle Owl",
    "latin_name": "Bubo lacteus",
    "animal_type": "Bird",
    "active_time": "Nocturnal",
    "length_min": "1.75",
    "length_max": "2.17",
    "weight_min": "3.56",
    "weight_max": "4.41",
    "lifespan": "30",
    "habitat": "Dry and tropical areas, acacia trees, woodlands and savannas ",
    "diet": "Medium-sized mammals and some larger birds",
    "geo_range": "Central to southern Africa ",
    "image_link": "https://upload.wikimedia.org/wikipedia/commons/e/ef/2012-giant-eagle-owl.jpg",
    "id": 181
}
*/
data class NewsResponse(
    var name: String,
    @SerializedName("latin_name")
    var latinName: String,
    @SerializedName("animal_type")
    var animalType: String,
    @SerializedName("active_time")
    var activeTime: String,
    @SerializedName("length_min")
    var lengthMin: String,
    @SerializedName("length_max")
    var lengthMax: String,
    @SerializedName("weight_min")
    var weightMin: String,
    @SerializedName("weight_max")
    var weightMax: String,
    @SerializedName("lifespan")
    var lifespan: String,
    @SerializedName("habitat")
    var habitat: String,
    @SerializedName("diet")
    var diet: String,
    @SerializedName("geo_range")
    var geoRange: String,
    @SerializedName("image_link")
    var imageLink: String,
    @SerializedName("id")
    var id: String,

)
