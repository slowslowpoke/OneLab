package com.example.onelab

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.onelab.data.Dataset

class CityFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_city, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf {
            it.containsKey(Dataset.POSITION)
        }?.apply {
            val position = getInt(Dataset.POSITION)
            val tvCityFact: TextView = view.findViewById(R.id.tv_city_fact)
            val ivCityImage: ImageView = view.findViewById(R.id.iv_city_image)
            with(Dataset.cities[position]) {
                tvCityFact.text = cityFact
                ivCityImage.setImageResource(imageResourceId)
                ivCityImage.setOnClickListener { searchOnGoogle(cityName) }
            }
        }
    }


    private fun searchOnGoogle(searchWord: String) {
        val webPage = Uri.parse("https://www.google.com/search?q=$searchWord")
        val intent = Intent(Intent.ACTION_VIEW, webPage)
        activity?.startActivity(intent)
    }
}