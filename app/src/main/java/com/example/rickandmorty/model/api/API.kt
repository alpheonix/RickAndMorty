package com.example.rickandmorty.model.api

import com.example.rickandmorty.interfaces.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class API {
    companion object{
        private var retrofit: Retrofit?=null

        val client:Retrofit get() {
            if(retrofit == null){
                retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(Constant.BASE_URL)
                    .build()
            }
            return retrofit!!
        }
    }
}