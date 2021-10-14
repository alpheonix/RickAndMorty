package com.example.rickandmorty.model.datamodel

import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("count") val count : Int,
    @SerializedName("pages") val pages : Int,
    @SerializedName("prev") val prev : String,
    @SerializedName("next") val next : String)
