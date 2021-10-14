package com.example.rickandmorty.fragments

import android.os.Bundle
import android.telecom.Call
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.rickandmorty.R


class DetailFragment : Fragment() {
    private lateinit var nameTv: TextView
    private lateinit var statusTv: TextView
    private lateinit var genderTv: TextView
    private lateinit var speciesTv: TextView
    private lateinit var typeTv: TextView
    private lateinit var originTv: TextView
    private lateinit var imageImv: ImageView


    private val args by navArgs<DetailFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_detail, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nameTv = view.findViewById(R.id.detail_name_tv)
        speciesTv = view.findViewById(R.id.detail_species_tv)
        originTv = view.findViewById(R.id.detail_origin_tv)
        typeTv = view.findViewById(R.id.detail_type_tv)
        statusTv = view.findViewById(R.id.detail_status_tv)
        genderTv = view.findViewById(R.id.detail_gender_tv)
        imageImv = view.findViewById(R.id.detail_image_imv)
        Glide.with(this).load(args.image).circleCrop().into(imageImv)
        nameTv.text = "Name: "+args.name
        speciesTv.text = "Species: "+args.species
        statusTv.text = "ALIVE ?: "+args.status
        originTv.text = "Comes from ? : "+args.origin
        typeTv.text = "What is he/she ? : "+args.type
        genderTv.text = "He ? She ? : "+args.gender
    }
}