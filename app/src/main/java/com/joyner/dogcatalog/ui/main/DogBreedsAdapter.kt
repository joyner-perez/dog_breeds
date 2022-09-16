package com.joyner.dogcatalog.ui.main

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.joyner.dogcatalog.R
import com.joyner.dogcatalog.data.models.local.DogBreed
import com.joyner.dogcatalog.databinding.ViewDogBinding
import com.joyner.dogcatalog.ui.common.inflate
import com.joyner.dogcatalog.ui.common.loadUrl

class DogBreedsAdapter(private val listener: (DogBreed) -> Unit) :
    RecyclerView.Adapter<DogBreedsAdapter.ViewHolder>() {

    var items: List<DogBreed> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.view_dog, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("DogBreedsAdapter", "$items")
        val dogBreed = items[position]
        holder.bind(dogBreed)
        holder.itemView.setOnClickListener { listener(dogBreed) }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ViewDogBinding.bind(view)
        fun bind(dogBreed: DogBreed) = with(binding) {
            dogBreedTitle.text = dogBreed.breed
            dogBreedImage.loadUrl("https://dog.ceo/api/breed/${dogBreed.breed}/images/random")
        }
    }
}