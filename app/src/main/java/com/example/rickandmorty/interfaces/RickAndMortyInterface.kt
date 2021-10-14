package com.example.rickandmorty.interfaces

import com.example.rickandmorty.model.datamodel.Character
import com.example.rickandmorty.presenter.CharacterPresenter

interface RickAndMortyInterface {
    interface RickAndMortyModel{
        fun getCharacterWithParam(preseter: CharacterPresenter, status: String, gender: String)
        fun getCharacter()
    }
    interface RickAndMortyView{
        fun updateViewData()
    }
    interface RickAndMortyPresenter{
        fun getCharacterWithPAram(status: String, gender: String)
        fun showCharacter()
        fun UIAutoUpdate()
    }
}