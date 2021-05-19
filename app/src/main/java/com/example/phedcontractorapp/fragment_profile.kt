package com.example.phedcontractorapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.phedcontractorapp.databinding.FragmentContractorProfileBinding
import com.example.phedcontractorapp.utils.Util


class fragment_profile:  Fragment(R.layout.activity_layout_profile)  {

    var count=0
    companion object {

        fun newInstance(): fragment_profile {
            return fragment_profile()
        }
    }

    //3
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding: FragmentContractorProfileBinding? = null
        binding = FragmentContractorProfileBinding.inflate(inflater, container, false)
        val view = inflater?.inflate(
            R.layout.fragment_contractor_profile,
            container, false
        )
        binding.backImg.setOnClickListener {

            activity?.finish()

        }

        binding!!.dropDown.setOnClickListener {

            if(!binding!!.layoutAgencyVisible.isVisible){
                binding!!.layoutAgencyVisible.isVisible=true;
                binding!!.dropDown.setBackgroundResource(R.drawable.ic_drop_up);

            }else{

                binding!!.layoutAgencyVisible.isVisible=false
                binding!!.dropDown.setBackgroundResource(R.drawable.ic_drop_down);
            }




        }

        binding!!.dropDownAddress.setOnClickListener {

            if(!binding!!.layoutAddressVisible.isVisible){
                binding!!.layoutAddressVisible.isVisible=true;
                binding!!.dropDownAddress.setBackgroundResource(R.drawable.ic_drop_up);

            }else{

                binding!!.layoutAddressVisible.isVisible=false
                binding!!.dropDownAddress.setBackgroundResource(R.drawable.ic_drop_down);
            }
        }

        binding!!.dropDownOffice.setOnClickListener {


            if(!binding!!.layoutOfficeVisible.isVisible){
                binding!!.layoutOfficeVisible.isVisible=true;
                binding!!.dropDownOffice.setBackgroundResource(R.drawable.ic_drop_up);

            }else{

                binding!!.layoutOfficeVisible.isVisible=false
                binding!!.dropDownOffice.setBackgroundResource(R.drawable.ic_drop_down);
            }
        }

        binding.backImg.setOnClickListener {

            count++

            if(count==1){

                activity?.let { it1 -> Util.toastMessage(it1, R.string.back_string) }
            }
            if(count==2) {

                activity?.finish()
            }


        }

        return binding.root
    }

      override fun onAttach(context: Context) {

        super.onAttach(context!!)

          count=0;
    }


    override fun onViewCreated(
        view: View,
        @Nullable savedInstanceState: Bundle?
    ) {

        super.onViewCreated(
            view,
            savedInstanceState
        )

    }

    override fun onActivityCreated(@Nullable savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)


    }

    override fun onStart() {

        super.onStart()

    }

    override fun onResume() {


        super.onResume()

    }

    override fun onPause() {
        super.onPause()

    }

    override fun onStop() {

        super.onStop()

    }

    override fun onDestroyView() {

        super.onDestroyView()

    }

    override fun onDestroy() {

        super.onDestroy()


    }

    override fun onDetach() {

        super.onDetach()

    }
}