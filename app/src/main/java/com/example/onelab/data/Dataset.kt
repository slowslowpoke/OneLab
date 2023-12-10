package com.example.onelab.data

import com.example.onelab.R

class Dataset {
    companion object {
        const val POSITION = "position"
        val cities = arrayOf(
            City(
                "Edinburgh",
                R.drawable.edinburgh,
                "Want to visit on a rainy day. Beautiful, hilly landscape, lots of old castles, thick atmosphere. Destination number 1"
            ),
            City(
                "Seoul",
                R.drawable.seoul,
                "This country has been feeding me for the last 5 years. Now it's time to go and taste the food on site"
            ),
            City(
                "Hamburg",
                R.drawable.hamburg,
                "Synonym of a bustling port-city for me. Want to feel the atmosphere."
            ),
            City(
                "London",
                R.drawable.london,
                "First saw it in school textbooks. The incarnation of 'The West' to me."
            )
        )
    }
}

