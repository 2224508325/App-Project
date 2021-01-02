package com.example.myapplication.fragments

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.EricActivity
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.SearchActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_doctor.*


class ProductFragmet : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //top bar enable
        setHasOptionsMenu(true)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_fragmet, container, false)
    }


    //Top Bar
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.customactionbar,menu)
        super.onCreateOptionsMenu(menu, inflater)

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var itemview = item.itemId
        when (itemview) {
            //when click on search it does something
            R.id.Search -> {
                    val intent = Intent (activity, SearchActivity::class.java)
                    startActivity(intent)
                }

            R.id.BarcodeScan -> Toast.makeText(getActivity(), "Scanner CLicked", Toast.LENGTH_SHORT)
                .show()
        }
        return false
    }
    //End of Top Bar
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)






    }




}