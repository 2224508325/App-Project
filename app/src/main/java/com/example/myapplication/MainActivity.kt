package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.widget.SearchView


import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.fragments.DoctorFragment
import com.example.myapplication.fragments.ProductFragmet
import com.example.myapplication.fragments.SymptomFragment
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_recyclerview.*



class MainActivity : AppCompatActivity() {

    //list view for search
    private lateinit var adapter: ArrayAdapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Top Search Icon Call
        setSupportActionBar(ToolBar)




        //Bottom Nav
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
        } //End Bottom Nav


    }

    //Top Search with Strings
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var itemview = item.itemId

        when(itemview){
            R.id.SearchButton -> {
                val intent = Intent(this,Recyclerview::class.java)
                startActivity(intent)
            }
            R.id.BarcodeScan ->{
                Toast.makeText(applicationContext,"Barcode not ready yet",Toast.LENGTH_SHORT).show()
            }
        }
        return false
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.nav_search, menu)
        val menuItem = menu!!.findItem(R.id.SearchButton)
        return true
    }
    //Top Search with Strings



   //Bottom Nav
    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
    //End Bottom Nav




    }



