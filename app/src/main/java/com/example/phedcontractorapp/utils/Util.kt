package com.example.phedcontractorapp.utils

import android.Manifest
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.OpenableColumns
import android.text.InputFilter
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.*


object Util {
    var blockCharacterSet: kotlin.String? = "~^|$%&*!@=+)(*%!:;''><|}]{[`#_×÷"
    val REQUEST_CODE = 200


    fun hideKeyboard(v: View) {

        try {
            val imm =
                v.context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.hideSoftInputFromWindow(v.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }


    }

    fun toastMessage(ctx: Context, msg: Int) {

        Toast.makeText(
            ctx,
            msg,
            Toast.LENGTH_SHORT
        ).show()
    }

    val filter =
        InputFilter { source, start, end, dest, dstart, dend ->
            if (source != null && blockCharacterSet!!.contains("" + source)) {
                ""
            } else null
        }

    fun showPermissionRequestExplanation(
        ctx: Context,
        permission: String,
        message: String,
        retry: (() -> Unit)? = null
    ) {
        AlertDialog.Builder(ctx).apply {
            setTitle("$permission Required")
            setMessage(message)
            setPositiveButton("Ok") { _, _ -> retry?.invoke() }
        }.show()
    }

    fun showPermissions(ctx: Context) {


        Dexter.withContext(ctx)
            .withPermissions(
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,

                ).withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport) { /* ... */
                }

                override fun onPermissionRationaleShouldBeShown(
                    permissions: List<PermissionRequest?>?,
                    token: PermissionToken?
                ) { /* ... */
                }
            }).check()
    }


    fun alertDialog(ctx: Context?, tittle: Int, message: Int, context: Context) {

        val builder = AlertDialog.Builder(ctx!!)

        //set title for alert dialog
        builder.setTitle(tittle)
        //set message for alert dialog
        builder.setMessage(message)
        builder.setIcon(android.R.drawable.ic_dialog_alert)

        //performing positive action
        builder.setPositiveButton("Yes") { dialogInterface, which ->




        }

        //performing negative action
        builder.setNegativeButton("No") { dialogInterface, which ->





        }
        // Create the AlertDialog
        val alertDialog: AlertDialog = builder.create()
        // Set other dialog properties
        alertDialog.setCancelable(false)
        alertDialog.show()


    }
    fun getSize(context: Context, uri: Uri?): String? {
        var fileSize: Long? = null
        val cursor: Cursor? = uri?.let {
            context.contentResolver
                .query(it, null, null, null, null, null)
        }
        try {
            if (cursor != null && cursor.moveToFirst()) {

                // get file size
                val sizeIndex: Int = cursor.getColumnIndex(OpenableColumns.SIZE)
                if (!cursor.isNull(sizeIndex)) {
                    fileSize = cursor.getLong(sizeIndex)
                }
            }
        } finally {
            cursor?.close()
        }
        return fileSize?.let { bytesIntoHumanReadable(it) }
    }


    fun getName(context: Context, uri: Uri?): String? {
        var fileName: String? = null
        val cursor = context.contentResolver
            .query(uri!!, null, null, null, null, null)
        try {
            if (cursor != null && cursor.moveToFirst()) {
                // get file name
                fileName = cursor.getString(
                    cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                )
            }
        } finally {
            cursor!!.close()
        }
        return fileName
    }


    private fun bytesIntoHumanReadable(bytes: Long): String? {
        val kilobyte: Long = 1024
        val megabyte = kilobyte * 1024
        val gigabyte = megabyte * 1024
        val terabyte = gigabyte * 1024
        return if (bytes >= 0 && bytes < kilobyte) {
            "$bytes B"
        } else if (bytes >= kilobyte && bytes < megabyte) {
            (bytes / kilobyte).toString() + " KB"
        } else if (bytes >= megabyte && bytes < gigabyte) {
            (bytes / megabyte).toString() + " MB"
        } else if (bytes >= gigabyte && bytes < terabyte) {
            (bytes / gigabyte).toString() + " GB"
        } else if (bytes >= terabyte) {
            (bytes / terabyte).toString() + " TB"
        } else {
            "$bytes Bytes"
        }
    }

    fun getCurrentDate(ctx:Context): String{

        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())

        return timeStamp
    }

}
