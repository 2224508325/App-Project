package com.example.myapplication.Andy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_recyclerview.*
import java.util.*


class Recyclerview : AppCompatActivity() {

    val givenData = arrayListOf<ProductTempleteinRecyclerView>(
        ProductTempleteinRecyclerView("Med 1"),
        ProductTempleteinRecyclerView("painrelief 2"),
        ProductTempleteinRecyclerView("aching solve 3")
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)

        setSupportActionBar(ToolBar)
        //set no animation
        window.setWindowAnimations(0)

        //initilize with empety array list

        val recyclerAdapter = RecyclerAdapter(givenData)
        recyclerview.apply{
            adapter = recyclerAdapter
            addItemDecoration(DividerItemDecoration(this@Recyclerview,DividerItemDecoration.VERTICAL))
            setHasFixedSize(true)
        }

    }

    //Top Search with Strings
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var itemview = item.itemId

        when(itemview){
            R.id.SearchButton -> {
                val intent = Intent(this, Recyclerview::class.java)
                startActivity(intent)
            }
            R.id.BarcodeScan ->{
                Toast.makeText(applicationContext,"Barcode not ready yet", Toast.LENGTH_SHORT).show()
            }
        }
        return false
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.nav_search, menu)

        val menuItem = menu!!.findItem(R.id.SearchButton)

        if(menuItem != null){
            val searchView = menuItem.actionView as SearchView
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextChange(newText: String?): Boolean {
                    return true
                }

                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }
            })
        }

        return super.onCreateOptionsMenu(menu)
    }
    //Top Search with Strings


}