package com.example.phedcontractor

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.phedcontractorapp.databinding.ActivityMainBinding


class splash : AppCompatActivity(), View.OnClickListener {

    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding!!.root)

        binding!!.buttonLogin.setOnClickListener(this)

        binding!!.buttonRegister.setOnClickListener {

            val intent=Intent(this,register:: class.java)
            startActivity(intent)

        }



    }

    override fun onClick(v: View?) {
        val intent = Intent(applicationContext, login::class.java)
        startActivity(intent)
        finish()
    }
}

