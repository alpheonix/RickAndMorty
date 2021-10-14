package com.example.rickandmorty.model.api

import com.example.rickandmorty.model.datamodel.ResultApi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIServices {
    @GET("character/")
    fun getCharacterWithoutParam(@Query("status") status:String, @Query("gender") gender:String):Call<ResultApi>
}