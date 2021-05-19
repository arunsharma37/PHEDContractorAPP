package com.example.phedcontractorapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.example.phedcontractorapp.databinding.ActivityComplaintListBinding
import com.example.phedcontractorapp.utils.Util


class complaint_list_details: AppCompatActivity() {
    val PICKFILE_RESULT_CODE=1;

    private var binding1 : ActivityComplaintListBinding?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding1 = ActivityComplaintListBinding.inflate(layoutInflater)
        setContentView(binding1!!.root)

        binding1!!.edtRemarks.filters= arrayOf(Util.filter)

        binding1!!.buttonReopen.setOnClickListener {
            binding1!!.layoutReopen.visibility=View.VISIBLE
             binding1!!.btnSatisfyReopen.visibility=View.GONE
            binding1!!.textReopenReason.text="Reopen Reason"
             binding1!!.textRating.visibility=View.GONE
             binding1!!.starRating.visibility=View.GONE
             binding1!!.btnAttach.visibility=View.VISIBLE



        }
        binding1!!.buttonReasonCancel.setOnClickListener {

            binding1!!.layoutReopen.visibility=View.GONE
            binding1!!.btnSatisfyReopen.visibility=View.VISIBLE

        }
        binding1!!.buttonSatisfyFeedback.setOnClickListener {

            binding1!!.textRating.visibility=View.VISIBLE
            binding1!!.starRating.visibility=View.VISIBLE
            binding1!!.btnSatisfyReopen.visibility=View.GONE
            binding1!!.layoutReopen.visibility=View.VISIBLE
            binding1!!.textReopenReason.text="Any Feedback(Optional)"
            binding1!!.btnAttach.visibility=View.GONE

        }

        binding1!!.buttonSubmitReason.setOnClickListener {

         //   val text_reopen_reasaon=binding1!!.textReopenReason.text
            val text_reopen_reasaon: String = binding1!!.textReopenReason.text.toString()

         if(text_reopen_reasaon=="Reopen Reason") {
             Toast.makeText(
                 applicationContext,
                 "Complaint has been reopened successfully",
                 Toast.LENGTH_SHORT
             ).show()
             finish()
         }

            if(text_reopen_reasaon=="Any Feedback(Optional)") {
                Toast.makeText(
                    applicationContext,
                    "Thanks For your Feedback",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }

        }

    binding1!!.btnAttach.setOnClickListener {




            var chooseFile = Intent(Intent.ACTION_GET_CONTENT)
            chooseFile.type = "*/*"
            chooseFile = Intent.createChooser(chooseFile, "Choose a file")
            startActivityForResult(chooseFile, PICKFILE_RESULT_CODE)



    }

        binding1!!.backImg.setOnClickListener {




            finish()
        }

    }

}