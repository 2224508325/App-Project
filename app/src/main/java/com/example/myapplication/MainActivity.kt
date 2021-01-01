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


import androidx.fragment.app.Fragment
import com.example.myapplication.fragments.DoctorFragment
import com.example.myapplication.fragments.ProductFragmet
import com.example.myapplication.fragments.SymptomFragment
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //list view for search
    private lateinit var adapter: ArrayAdapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
/*
       //for search
        adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,resources.getStringArray(R.array.countries_array))
        lv_listview.adapter = adapter
        lv_listview.onItemClickListener = AdapterView.OnItemClickListener {parent,view,position,id ->
            Toast.makeText(applicationContext,parent?.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT ).show()
        }
        lv_listview.emptyView = tv_emptyTextView
        //search ended*/




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


/*    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_search,menu)
        val search = menu?.findItem(R.id.nav_search)
        val searchView = search?.actionView as SearchView
        searchView.queryHint = "Search Here"

    searchView.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
        override fun onQueryTextSubmit(query: String?): Boolean {
            return false
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            adapter.filter.filter(newText)
            return true
        }
    })
        return super.onCreateOptionsMenu(menu)

    }
    //end Top search*/

   //Bottom Nav
    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
    //End Bottom Nav

    }