package com.example.rickandmorty.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.compose.ui.text.toLowerCase
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.rickandmorty.R


class FilterFragment : Fragment() {
    private lateinit var genderEdt: EditText
    private lateinit var statusEdt: EditText
    private lateinit var button: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_filter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        genderEdt = view.findViewById(R.id.filter_gender_edit)
        statusEdt = view.findViewById(R.id.filter_status_edit)
        button = view.findViewById(R.id.filter_button)

        button.setOnClickListener {
            var gender = genderEdt.text.toString().lowercase()
            var status = statusEdt.text.toString().lowercase()
            Log.d("filter",gender)
            Log.d("filter",status)

            if(gender.isEmpty()|| gender !="female"&& gender !="male"&& gender !="Genderless"&& gender !="unknown"){
                gender = " "
            }
            if(status.isEmpty()|| status !="alive"&& status !="dead"&& status !="unknown"){
                status = " "
            }

            findNavController().navigate(
                FilterFragmentDirections.actionFilterFragmentToCharacterFragment(
                    status,
                    gender
                )
            )

        }
    }
}