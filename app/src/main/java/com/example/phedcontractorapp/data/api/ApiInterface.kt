package com.example.phedcontractorapp.data.api

 import com.example.phedcontractorapp.data.model.StatesModel
 import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("states")
    fun getStateServices() : Call<StatesModel>

}