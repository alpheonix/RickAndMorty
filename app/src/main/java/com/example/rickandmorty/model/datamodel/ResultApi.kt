package com.example.rickandmorty.model.datamodel

import com.google.gson.annotations.SerializedName
data class ResultApi(
    @SerializedName("info") val info:Info,
    @SerializedName("results") val results : List<Character>,
)
