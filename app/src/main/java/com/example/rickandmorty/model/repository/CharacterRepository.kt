package com.example.rickandmorty.model.repository

import android.util.Log
import com.example.rickandmorty.fragments.CharacterFragment
import com.example.rickandmorty.interfaces.RickAndMortyInterface
import com.example.rickandmorty.model.api.API
import com.example.rickandmorty.model.api.APIServices
import com.example.rickandmorty.model.datamodel.ResultApi
import com.example.rickandmorty.presenter.CharacterPresenter
import com.example.rickandmorty.model.datamodel.Character
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterRepository: RickAndMortyInterface.RickAndMortyModel {

    private var character = "Rick"
    private var apiClient : APIServices?= null

    init {
        apiClient = API.client.create(APIServices::class.java)
    }

    override fun getCharacterWithParam(preseter: CharacterPresenter, status: String, gender: String) {
        val call = apiClient?.getCharacterWithoutParam(status,gender)
        call?.enqueue(object  : Callback<ResultApi>{
            override fun onResponse(call: Call<ResultApi>, response: Response<ResultApi>) {
                if(response.isSuccessful){
                    var result = response.body()?.results
                    Log.d("test",result?.get(0).toString())

                    CharacterFragment.characterAdapter.data = result as ArrayList<Character>
                }
            }

            override fun onFailure(call: Call<ResultApi>, t: Throwable) {
                Log.d("errrrrrror",t.toString())
            }

        })
    }

    override fun getCharacter() {

    }

}