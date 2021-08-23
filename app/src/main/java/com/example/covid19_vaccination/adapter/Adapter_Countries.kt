package com.example.covid19_vaccination.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.covid19_vaccination.databinding.RecyclerRowForCountriesFragmentBinding
import com.example.covid19_vaccination.view.CountriesFragmentDirections

class Adapter_Countries(val countryName:ArrayList<String>,val countryImage:ArrayList<String>,val context:Context):RecyclerView.Adapter<Adapter_Countries.TutucuVH>() {
    class TutucuVH(val binding:RecyclerRowForCountriesFragmentBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TutucuVH {
    val view=TutucuVH(RecyclerRowForCountriesFragmentBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    return view
    }

    override fun onBindViewHolder(holder: TutucuVH, position: Int) {
        try {
            holder.binding.textViewCountryName.text="Location : ${countryName.get(position)}"
            holder.binding.imageViewForCountries.setImageResource(context.resources.getIdentifier(countryImage.get(position),"drawable",context.packageName))
            holder.itemView.setOnClickListener {
                val action=CountriesFragmentDirections.actionCountriesFragmentToDatasFragment(countryName.get(position),countryImage.get(position))
                Navigation.findNavController(it).navigate(action)
            }
        }catch (e:Exception){

        }

    }

    override fun getItemCount(): Int {
        return countryImage.size
    }
}