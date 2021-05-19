package com.example.phedcontractor

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.phedcontractorapp.R

import com.example.phedcontractorapp.databinding.ActivityRegisterAgencyBinding

class Register_agency_details: AppCompatActivity() {

    var binding: ActivityRegisterAgencyBinding? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterAgencyBinding.inflate(layoutInflater)

        setContentView(binding!!.root)

        val constitution_type = resources.getStringArray(R.array.constitutions)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, constitution_type)
        this.binding!!.spinnerConstitutionType.adapter = adapter
        binding!!.spinnerConstitutionType.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                Toast.makeText(
                    this@Register_agency_details,
                    getString(R.string.selected_item) + " " +
                            "" + constitution_type[position], Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }

        binding!!.imgNext.setOnClickListener {

            var intent=Intent(this,Register_address_details:: class.java)
            startActivity(intent)

        }

        binding!!.imgBack.setOnClickListener {

            finish();
        }
    }
}