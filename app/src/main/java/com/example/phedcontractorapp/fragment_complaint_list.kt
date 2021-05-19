package com.example.phedcontractorapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.phedcontractorapp.databinding.FragmentComplaintListBinding
import com.example.phedcontractorapp.utils.Util


class fragment_complaint_list : Fragment()  {

    var count=0
    val view =null
    var binding: FragmentComplaintListBinding? = null

    companion object {

        fun newInstance(): fragment_complaint_list {
            return fragment_complaint_list()
        }
    }

    //3
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        if (view == null){

        binding = FragmentComplaintListBinding.inflate(inflater, container, false)
        val view = inflater?.inflate(
            R.layout.fragment_complaint_list,
            container, false
        )

        }
        binding?.backImg?.setOnClickListener {

            activity?.finish()

        }

        binding!!.cardTotalComp.setOnClickListener {






        }

        binding!!.inProgress.setOnClickListener {


        }

        binding!!.inClosed.setOnClickListener {


            val intent = Intent(this.activity, complaint_list_details::class.java)
            startActivity(intent)


        }

        binding!!.backImg.setOnClickListener {

            count++

            if(count==1){

                activity?.let { it1 -> Util.toastMessage(it1, R.string.back_string) }
            }
            if(count==2) {

                activity?.finish()
            }


        }



        return binding!!.root
    }
    override fun onAttach(context: Context) {

        super.onAttach(requireContext())

        count=0;
    }


}