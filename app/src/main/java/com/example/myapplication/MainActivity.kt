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
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.fragments.DoctorFragment
import com.example.myapplication.fragments.ProductFragmet
import com.example.myapplication.fragments.SymptomFragment
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


/*
            // for EricActivity
            val ericStart: Button = findViewById(R.id.ericStartActivity)
            ericStart.setOnClickListener {
                startActivity(Intent(this, EricActivity::class.java))
            }
            Toast.makeText(this, "Firebase Connection Success", Toast.LENGTH_LONG).show()
*/


        //Andy's Part
        val productFragment = ProductFragmet()
        val symptomFragment = SymptomFragment()
        val doctorFragment = DoctorFragment()
        makeCurrentFragment(productFragment)
        bottom_navigation.setOnNavigationItemSelectedListener{
            when (it.itemId){
                R.id.ic_product -> makeCurrentFragment(productFragment)
                R.id.ic_symptom -> makeCurrentFragment(symptomFragment)
                R.id.ic_doctor -> makeCurrentFragment(doctorFragment)
            }
            true
        } //End of Andy's Part



    }

    //Andy Part
    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
    //End Andy part


    }