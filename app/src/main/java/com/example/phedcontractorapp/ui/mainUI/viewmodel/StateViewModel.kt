package com.example.phedcontractorapp.ui.mainUI.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.phedcontractorapp.data.model.StatesModel
import com.example.phedcontractorapp.data.repository.StateRepositry


class StateViewModel : ViewModel() {

    var servicesLiveData: MutableLiveData<StatesModel>? = null

    fun getUser() : LiveData<StatesModel>? {
        servicesLiveData = StateRepositry.getServicesApiCall()
        return servicesLiveData
    }

}