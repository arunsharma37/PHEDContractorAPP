package com.example.phedcontractor

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.phedcontractorapp.databinding.ActivityLoginBinding


class login: AppCompatActivity() {
    private var binding1 : ActivityLoginBinding?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding1 = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding1!!.root)
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        binding1!!.buttonLogin.setOnClickListener {

            val contractor_id: String = binding1!!.inputContractorId.text.toString()
            val btn_text: String =binding1!!.buttonLogin.getText().toString()
            if(btn_text=="Login"){
                val otp: String = binding1!!.inputOtp.text.toString()

                if (otp.trim().length > 0) {
               //     val intent = Intent(this, contractor_profile::class.java)
                    val intent = Intent(this, dashboard::class.java)
                    startActivity(intent)
                    finish()
                }else{
                    Toast.makeText(
                        applicationContext,
                        "Kindly enter the received otp",
                        Toast.LENGTH_SHORT
                    ).show()
                }





            }


            if(btn_text=="Send OTP") {
                if (contractor_id.trim().length > 0) {

                    Toast.makeText(
                        applicationContext,
                        "OTP Sent To Your Registered Mobile Number",
                        Toast.LENGTH_SHORT
                    ).show()
                    binding1!!.textOtp.visibility = View.VISIBLE
                    binding1!!.inputOtp.visibility = View.VISIBLE
                    binding1!!.buttonLogin.text = "Login"
                } else {

                    Toast.makeText(
                        applicationContext,
                        "Contractor ID cannot be empty",
                        Toast.LENGTH_SHORT
                    ).show()

                }


            }

        }



    }
    }

