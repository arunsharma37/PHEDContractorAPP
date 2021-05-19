package com.example.phedcontractor

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.example.phedcontractorapp.databinding.ActivityRegisterBinding

class register: AppCompatActivity() {

    var binding: ActivityRegisterBinding?=null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding!!.imgNext.setOnClickListener {

           val intent= Intent(this,Register_agency_details:: class.java)
            startActivity(intent)
        }
        binding!!.imgBack.setOnClickListener {

           finish()
        }


    }
}