package com.example.phedcontractorapp.data.repository





import android.util.Log
import androidx.lifecycle.MutableLiveData

import com.example.phedcontractorapp.retrofit
import com.example.phedcontractorapp.data.model.StatesModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object StateRepositry {

    val serviceSetterGetter = MutableLiveData<StatesModel>()

    fun getServicesApiCall(): MutableLiveData<StatesModel> {

        val call = retrofit.apiInterface.getStateServices()

        call.enqueue(object: Callback<StatesModel> {
            override fun onFailure(call: Call<StatesModel>, t: Throwable) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<StatesModel>,
                response: Response<StatesModel>
            ) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", response.body().toString())

                val data = response.body()

                val msg = data!!.name


                serviceSetterGetter.value = StatesModel(msg)
            }
        })

        return serviceSetterGetter
    }
}