package com.example.rickandmorty.fragments

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.rickandmorty.R
import com.example.rickandmorty.model.datamodel.Character

class CharacterAdapter:RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    var data: ArrayList<Character> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var listener: ((Character) -> Unit)? = null

    override fun getItemCount() = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)
    }


    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = data[position]


        with(holder) {
            Log.d("char",character.toString())
            Glide.with(itemView)
                .load(character.image)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(thumbnailImv)

            itemView.setOnClickListener {listener?.invoke(character)}



        }
    }


    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //var nameTv : TextView = itemView.findViewById(R.id.item_character_tv)
        var thumbnailImv: ImageView = itemView.findViewById(R.id.item_character_imv)
    }
}