package com.example.rickandmorty.model.model

import com.google.gson.annotations.SerializedName

data class Info(
     val count : Int,
     val pages : Int,
     val prev : String,
     val next : String)
