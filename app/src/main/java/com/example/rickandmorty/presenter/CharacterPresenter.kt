package com.example.rickandmorty.presenter

import com.example.rickandmorty.interfaces.RickAndMortyInterface
import com.example.rickandmorty.model.repository.CharacterRepository

class CharacterPresenter(characterView : RickAndMortyInterface.RickAndMortyView): RickAndMortyInterface.RickAndMortyPresenter {
    private var model:RickAndMortyInterface.RickAndMortyModel= CharacterRepository()

    override fun getCharacterWithPAram(status: String, gender: String) {
        model.getCharacterWithParam(this,status,gender)
    }

    override fun showCharacter() {
        return model.getCharacter()
    }

    override fun UIAutoUpdate() {

    }

}