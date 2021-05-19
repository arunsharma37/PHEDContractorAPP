package com.example.phedcontractor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.phedcontractorapp.R

import com.example.phedcontractorapp.databinding.ActivityLayoutDashboardBinding
import com.example.phedcontractorapp.fragment_complaint_list
import com.example.phedcontractorapp.fragment_profile
import com.example.phedcontractorapp.fragment_register_complaint

class dashboard :  AppCompatActivity() {
    private var binding: ActivityLayoutDashboardBinding? = null
    var fragment_reg_comp: fragment_register_complaint?=null;
    var fragment_comp_list: fragment_complaint_list?=null;
    var fragment_profile: fragment_profile?=null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLayoutDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding!!.root)

        if(fragment_reg_comp==null){

            fragment_reg_comp=fragment_register_complaint();
        }
        if(fragment_comp_list==null){

            fragment_comp_list=fragment_complaint_list();
        }

        if(fragment_profile==null){

            fragment_profile=fragment_profile();
        }






        setCurrentFragment(fragment_reg_comp!!);
       binding!!.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.action_reg_comp->setCurrentFragment(fragment_reg_comp!!)
                R.id.action_comp_list->setCurrentFragment(fragment_comp_list!!)
                R.id.action_profile->setCurrentFragment(fragment_profile!!)

            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }

}