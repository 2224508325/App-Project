package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem


import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setSupportActionBar(findViewById(R.id.toolbar))


        val start_button: Button = findViewById(R.id.Andybtn)
        start_button.setOnClickListener {
            val intent = Intent(this, AndyActivity::class.java)
            startActivity(intent)
        }
        // for EricActivity
        val eric: Button = findViewById(R.id.ericActivity)
        eric.setOnClickListener {
            startActivity(Intent(this,EricActivity::class.java))
        }

        val showData: Button = findViewById(R.id.showItem)
        showData.setOnClickListener {
            startActivity(Intent(this,retrieveActivity2::class.java))
        }

        Toast.makeText(this, "Firebase Connection Success", Toast.LENGTH_LONG).show()


    }

        fun setstop() {
            findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show()
            }


        }

        override fun onCreateOptionsMenu(menu: Menu): Boolean {
            // Inflate the menu; this adds items to the action bar if it is present.
            menuInflater.inflate(R.menu.menu_main, menu)

            return true
        }


        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            return when (item.itemId) {
                R.id.action_settings -> true
                else -> super.onOptionsItemSelected(item)
            }
        }
    }