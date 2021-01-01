package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem


import android.widget.Button
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


            // for EricActivity
            val eric: Button = findViewById(R.id.ericActivity)
            eric.setOnClickListener {
                startActivity(Intent(this, EricActivity::class.java))
            }
            Toast.makeText(this, "Firebase Connection Success", Toast.LENGTH_LONG).show()


        }


    }