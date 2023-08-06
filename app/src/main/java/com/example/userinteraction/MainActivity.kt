package com.example.userinteraction

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var listview : ListView
    lateinit var showSnackbar : Button
    lateinit var layout : ConstraintLayout
    lateinit var showDialog : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listview = findViewById(R.id.lvCountry)
        showSnackbar = findViewById(R.id.btnSnackbar)
        layout = findViewById(R.id.constraintLayout)
        showDialog = findViewById(R.id.btnDialog)

        var countryList = resources.getStringArray(R.array.Country)
        var arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, countryList)

        listview.adapter = arrayAdapter
        listview.setOnItemClickListener { parent, view, position, id ->
            val name : String = parent.getItemAtPosition(position).toString()
            Toast.makeText(applicationContext, name, Toast.LENGTH_SHORT).show()
        }

        showSnackbar.setOnClickListener {
            Snackbar.make(layout, "This is a Snackbar Message", Snackbar.LENGTH_INDEFINITE)
                .setAction("OKAY", View.OnClickListener {

                }).show()
        }

        showDialog.setOnClickListener {
            showAlertDialog()
        }
    }

    private fun showAlertDialog() {
        var alertDialog = AlertDialog.Builder(this)

        alertDialog.setTitle("Exit")
            .setMessage("Are you sure you want to exit?")
            .setIcon(R.drawable.twotone_warning_24)
            .setCancelable(false)
            .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which ->
                dialog.cancel()
            })
            .setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
                showDialog.setText("Changed Successfully!")
            })
        alertDialog.create().show()
    }
}