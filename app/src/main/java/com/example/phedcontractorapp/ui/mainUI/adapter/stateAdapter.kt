package com.example.phedcontractorapp.ui.mainUI.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SpinnerAdapter
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.phedcontractor.Register_address_details
import com.example.phedcontractorapp.R
import com.example.phedcontractorapp.data.model.StatesModel
import com.example.phedcontractorapp.databinding.AcitivityStateItemBinding
import com.example.phedcontractorapp.databinding.ActivityAddressDetailsBinding
import com.example.phedcontractorapp.databinding.ActivityRegisterAgencyBinding




class stateAdapter(context: Context, countryList: List<StatesModel>) : ArrayAdapter<StatesModel>(context, 0, countryList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    private fun initView(position: Int, convertView: View?, parent: ViewGroup): View {

        val country = getItem(position)
       val binding: AcitivityStateItemBinding?=null;
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.acitivity_state_item, parent, false)


        if (country != null) {
            country.name.also { binding?.stateText!!.text = it }
        }



        return view
    }
}