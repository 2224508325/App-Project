package com.example.myapplication

import android.os.Bundle
import android.view.Menu
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.searchbar.*


class SearchActivity : AppCompatActivity() {

        //list view for search
        private lateinit var adapter: ArrayAdapter<*>
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.searchbar)

            //for search
            adapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                resources.getStringArray(R.array.countries_array)
            )
            lv_listview.adapter = adapter
            lv_listview.onItemClickListener =
                AdapterView.OnItemClickListener { parent, view, position, id ->
                    Toast.makeText(
                        applicationContext,
                        parent?.getItemAtPosition(position).toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            lv_listview.emptyView = tv_emptyTextView
            //search ended
        }

        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.nav_search,menu)
            val search = menu?.findItem(R.id.nav_search)
            val searchView = search?.actionView as SearchView
            searchView.queryHint = "Search Here"

            searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
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

    }