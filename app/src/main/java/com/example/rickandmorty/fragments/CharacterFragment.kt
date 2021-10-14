package com.example.rickandmorty.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.R
import com.example.rickandmorty.interfaces.RickAndMortyInterface
import com.example.rickandmorty.model.datamodel.Character
import com.example.rickandmorty.presenter.CharacterPresenter

class CharacterFragment : Fragment(), RickAndMortyInterface.RickAndMortyView {
    private lateinit var charactersRecyclerView: RecyclerView
    private var presenter:CharacterPresenter?=null
    companion object{
        val characterAdapter: CharacterAdapter by lazy { CharacterAdapter() }
    }
    private val args by navArgs<CharacterFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_character, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        charactersRecyclerView = view.findViewById(R.id.character_rcv)
        presenter = CharacterPresenter(this)
        presenter?.getCharacterWithPAram(args.status,args.gender)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        charactersRecyclerView.layoutManager = GridLayoutManager(context,2)
        charactersRecyclerView.adapter = characterAdapter
        charactersRecyclerView.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        )

        characterAdapter.listener = this::navigateToDetail


    }

    override fun updateViewData() {

    }
    private fun navigateToDetail(character: Character) {
        findNavController().navigate(
            CharacterFragmentDirections.actionCharacterFragmentToDetailFragment(
                character.name,
                character.image,
                character.status,
                character.species,
                character.type,
                character.gender,
                character.origin.name
            )
        )
    }
}