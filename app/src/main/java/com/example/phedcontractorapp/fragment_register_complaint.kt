package com.example.phedcontractorapp

import android.Manifest
import android.R
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.OpenableColumns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.phedcontractorapp.databinding.FragmentRegisterCompBinding
import com.example.phedcontractorapp.utils.Util
import com.example.phedcontractorapp.utils.Util.toastMessage


class fragment_register_complaint: Fragment() {
    val STORAGE_PERMISSION_CODE: Int? = 1
    val REQUEST_CODE = 200
    val PICKFILE_RESULT_CODE = 1
    var count = 0;
    var category: String? = null;
    var subcategory: String? = ""
    var remarks: String? = ""
    var dept_name: String? = "";
    var tander_no: String? = "";
    var work_no: String? = "";
    var _binding: FragmentRegisterCompBinding? = null
    val items_category = listOf(
        "Select Grievance Category",
        "Tender Evaluation",
        "EMB",
        "Billing Process",
        "Time Extension",
        "Inspection",
        "Completion",
        "Others"
    )
    var adapter_subcategory: ArrayAdapter<String>? = null;

    val items_dept = listOf("Select Department", "DULB", "PHED", "PWDBnR", "HSIIDC")


    companion object {


        var buttonStatus: String? = ""
        fun newInstance(): fragment_register_complaint {
            return fragment_register_complaint()
        }
    }

    //3
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        _binding = FragmentRegisterCompBinding.inflate(inflater, container, false)






        _binding!!.edtRemarks.filters = arrayOf(Util.filter)

        _binding!!.backImg.setOnClickListener {

            count++

            if (count == 1) {

                activity?.let { it1 ->
                    Util.toastMessage(
                        it1,
                        com.example.phedcontractorapp.R.string.back_string
                    )
                }

            }
            if (count == 2) {

                activity?.finish()
            }


        }


        val adapter_dept = ArrayAdapter(
            requireContext(),
            R.layout.simple_list_item_1,
            items_dept
        )

        _binding!!.spnGift.setAdapter(adapter_dept)


        val adapter_category = ArrayAdapter(
            requireContext(),
            R.layout.simple_list_item_1,
            items_category
        )
        _binding!!.categoryDrop.setAdapter(adapter_category)


        _binding!!.categoryDrop.setOnItemSelectedListener(object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                val item = parent.getItemAtPosition(position)

                if (item == "Tender Evaluation") {
                    val items_sub_category = listOf(
                        "Select Grievance Subcategory",
                        "Technical Evaluation",
                        "Financial Evaluation"
                    )
                    adapter_subcategory = ArrayAdapter(
                        requireContext(),
                        R.layout.simple_list_item_1,
                        items_sub_category
                    )
                    _binding!!.subCategoryDrop.setAdapter(adapter_subcategory)

                }
                if (item == "EMB") {
                    val items_sub_category = listOf(
                        "Select Grievance Subcategory",
                        " Regarding Recording of details",
                        "Verification of EMB"
                    )
                    adapter_subcategory = ArrayAdapter(
                        requireContext(),
                        R.layout.simple_list_item_1,
                        items_sub_category
                    )
                    _binding!!.subCategoryDrop.setAdapter(adapter_subcategory)

                }
                if (item == "Others") {

                    _binding!!.layoutSubcategoryDrop.visibility = View.GONE
                    _binding!!.textSubCategory.visibility = View.GONE

                }
                if (item == "Inspection") {
                    val items_sub_category = listOf(
                        "Select Grievance Subcategory",
                        "Third Party Inspection"
                    )
                    adapter_subcategory = ArrayAdapter(
                        requireContext(),
                        R.layout.simple_list_item_1,
                        items_sub_category
                    )
                    _binding!!.subCategoryDrop.setAdapter(adapter_subcategory)

                }

                if (item == "Billing Process") {
                    val items_sub_category = listOf(
                        "Select Grievance Subcategory",
                        "First Running Bill", "Running Bill", "Final Bill"
                    )
                    adapter_subcategory = ArrayAdapter(
                        requireContext(),
                        R.layout.simple_list_item_1,
                        items_sub_category
                    )
                    _binding!!.subCategoryDrop.setAdapter(adapter_subcategory)

                }

                if (item == "Time Extension") {

                    _binding!!.layoutSubcategoryDrop.visibility = View.GONE
                    _binding!!.textSubCategory.visibility = View.GONE

                }

                if (item == "Completion") {
                    _binding!!.layoutSubcategoryDrop.visibility = View.GONE
                    _binding!!.textSubCategory.visibility = View.GONE

                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        })


        _binding!!.buttonSubmit.setOnClickListener {

            //  dept_name =_binding!!.spnGift.selectedItem.toString()
            // tander_no=_binding!!.edtTender.text.toString()
            //work_no=_binding!!.edtWorkid.text.toString()

            if (_binding!!.spnGift.selectedItemPosition == 0) {

                Toast.makeText(
                    context,
                    "Kindly Select Department",
                    Toast.LENGTH_SHORT
                ).show()

            } else if (_binding!!.edtTender.text.toString()
                    .isEmpty() && _binding!!.edtWorkid.text.toString().isEmpty()
            ) {

                Toast.makeText(
                    context,
                    "Kindly Enter the Work or Tender Number",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                Util.hideKeyboard(it)
                _binding!!.layoutTenderDetails.visibility = View.VISIBLE
            }


        }

        _binding!!.btnAttach.setOnClickListener {


            if (ContextCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                //  val takePicture = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                //   startActivityForResult(takePicture, 0)
                openGalleryForImages();

            } else {

                requestPermission()

            }
        }





        _binding!!.buttonSubmitComp.setOnClickListener {

            // category =_binding!!.categoryDrop.selectedItem.toString()
            //    subcategory =_binding!!.subCategoryDrop.selectedItem.toString()
            remarks = _binding!!.edtRemarks.text.toString()


            if (_binding!!.categoryDrop.selectedItemPosition == 0) {

                Toast.makeText(
                    context,
                    "Kindly Select Grievance Category",
                    Toast.LENGTH_SHORT
                ).show()

            } else if (adapter_subcategory == null ||
                _binding!!.subCategoryDrop.selectedItemPosition == 0
            ) {
                Toast.makeText(
                    context,
                    "Kindly Select Grievance Subcategory",
                    Toast.LENGTH_SHORT
                ).show()

            } else if (_binding!!.edtRemarks.text.toString().isEmpty()) {
                Toast.makeText(
                    context,
                    "Grievance Remarks cannot be empty",
                    Toast.LENGTH_SHORT
                ).show()

            } else {
                Toast.makeText(
                    context,
                    "Grievance has been registered successfully.Your complaint id is 446783.Grievance " +
                            "details has been sent to your registered mobile number",
                    Toast.LENGTH_SHORT
                ).show()

            }

        }
        return _binding!!.root
    }


    override fun onAttach(context: Context) {

        super.onAttach(requireContext())


        count = 0;

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)


        outState.putString("category", category);
        outState.putString("subcategory", subcategory);
        outState.putString("remarks", remarks);


        outState.putString("dept_name", dept_name);
        outState.putString("tander_no", tander_no);
        outState.putString("work_no", work_no);
    }

    override fun onViewStateRestored(inState: Bundle?) {
        super.onViewStateRestored(inState)
        if (inState != null) {

            category =
                if (inState != null) inState.getString("greeting") else "null"
            subcategory =
                if (inState != null) inState.getString("subcategory") else "null"
            remarks =
                if (inState != null) inState.getString("remarks") else "null"


            dept_name =
                if (inState != null) inState.getString("dept_name") else "null"
            tander_no =
                if (inState != null) inState.getString("tander_no") else "null"
            work_no =
                if (inState != null) inState.getString("work_no") else "null"
        }
    }


    fun requestPermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(
                requireContext() as Activity,
                Manifest.permission.READ_EXTERNAL_STORAGE
            )
        ) {


            val builder = AlertDialog.Builder(requireContext())

            //set title for alert dialog
            builder.setTitle(com.example.phedcontractorapp.R.string.alert_tittle)
            //set message for alert dialog
            builder.setMessage(com.example.phedcontractorapp.R.string.alert_message)
            builder.setIcon(android.R.drawable.ic_dialog_alert)

            //performing positive action
            builder.setPositiveButton("Yes") { dialogInterface, which ->


                openGalleryForImages()

            }

            //performing negative action
            builder.setNegativeButton("No") { dialogInterface, which ->


            }
            // Create the AlertDialog
            val alertDialog: AlertDialog = builder.create()
            // Set other dialog properties
            alertDialog.setCancelable(false)
            alertDialog.show()


        } else {


            ActivityCompat.requestPermissions(
                context as Activity,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                1
            )
        }


    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        if (requestCode == STORAGE_PERMISSION_CODE) {

            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                context?.let {
                    toastMessage(
                        it,
                        com.example.phedcontractorapp.R.string.permmission_granted
                    )
                }

            } else {

                context?.let {
                    toastMessage(
                        it,
                        com.example.phedcontractorapp.R.string.permmission_denied
                    )
                }
            }

        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE) {

            // if multiple images are selected
            if (data?.getClipData() != null) {
                var count = data.clipData?.itemCount

                if (count != null) {
                    for (i in 0..count - 1) {

                        var imageUri: Uri? = data.clipData!!.getItemAt(i).uri
                   //     _binding!!.imageUri.setImageURI(imageUri) //Here you can assign your Image URI to the ImageViews
                      //  _binding!!.imageUri.visibility = View.VISIBLE
                    }
                }

            } else if (data?.getData() != null) {
                // if single image is selected
                var imageUri: Uri = data.data!!



                val mimeType: String? = data.data?.let { returnUri ->
                    context?.contentResolver?.getType(returnUri)
                }
                var img_size: String? =Util.getSize(requireContext(),imageUri)
                    Toast.makeText(context,img_size,Toast.LENGTH_SHORT).show()
                var img_name: String? =Util.getName(requireContext(),imageUri)

                _binding!!.textImg.setText(img_name+"."+mimeType+"\r\n" +"Size: "+img_size)

                Toast.makeText(context,img_name,Toast.LENGTH_SHORT).show()

            }
        }
    }

            fun openGalleryForImages() {

                if (Build.VERSION.SDK_INT < 19) {
                    var intent = Intent()
                    intent.type = "image/*"
                    intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
                    intent.action = Intent.ACTION_GET_CONTENT
                    startActivityForResult(
                        Intent.createChooser(intent, "Choose Pictures"), Util.REQUEST_CODE
                    )
                } else { // For latest versions API LEVEL 19+
                    var intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
                    intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
                    intent.addCategory(Intent.CATEGORY_OPENABLE)
                    intent.type = "image/*"
                    startActivityForResult(intent, Util.REQUEST_CODE);
                }
            }



    }


