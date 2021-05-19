package com.example.phedcontractorapp.data.model




data class StatesModel(val name: String)

object States {



    private val states = arrayOf(
        "All Countries",
        "India",
        "USA",
        "Australia",
        "United Kingdom",
        "China"
    )

    var list1: ArrayList<StatesModel>? = null
        get() {

            if (field != null)
                return field

            field = ArrayList()
            for (i in states.indices) {


                val countryName = states[i]

                val country = StatesModel(countryName)
                field!!.add(country)
            }

            return field
        }
}
