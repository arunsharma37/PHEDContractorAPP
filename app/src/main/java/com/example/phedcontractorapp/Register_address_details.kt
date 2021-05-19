package com.example.phedcontractor

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.phedcontractorapp.R
import com.example.phedcontractorapp.data.model.States
 import com.example.phedcontractorapp.data.model.States.list1
import com.example.phedcontractorapp.data.model.StatesModel

import com.example.phedcontractorapp.databinding.ActivityAddressDetailsBinding
import com.example.phedcontractorapp.ui.mainUI.adapter.stateAdapter
import com.example.phedcontractorapp.ui.mainUI.viewmodel.StateViewModel

class Register_address_details: AppCompatActivity() {
    var binding: ActivityAddressDetailsBinding?=null;

    lateinit var context: Context

    lateinit var registerViewModel: StateViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAddressDetailsBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        context = this@Register_address_details




      // val   _states: Array<String> = resources.getStringArray(R.array.states)
     //   val _Districts= resources.getStringArray(R.array.Districts)

    //    binding!!.spinnerState.adapter  = stateAdapter(_states)
   //     val adpater_state=ArrayAdapter.createFromResource(this,R.array.states,android.R.layout.simple_spinner_item)
      val adpater_districts=ArrayAdapter.createFromResource(this,R.array.Districts,android.R.layout.simple_spinner_item)

      //  val adapter_dist = ArrayAdapter(this, android.R.layout.simple_spinner_item, _Districts)
    //    adpater_state.setDropDownViewResource(android.R.layout.simple_spinner_item)
    //    binding!!.spinnerState.adapter = adpater_state

        val adapter_state= list1?.let { stateAdapter(this, it) }
        this.binding!!.spinnerState.adapter=adapter_state

        binding!!.spinnerState.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {

            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }
        this.binding!!.spinnerDistrict.adapter = adpater_districts
        binding!!.spinnerDistrict.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {

            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }

        registerViewModel = ViewModelProvider(this).get(StateViewModel::class.java)



        binding!!.imgBack.setOnClickListener {

            finish();
        }

    }
}



