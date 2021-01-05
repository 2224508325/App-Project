package com.example.myapplication

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_search_eric.*

class ericSearchActivity:AppCompatActivity() {
    private val firebaseFirestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    private var searchList:List<searchModel> = ArrayList()
    private val searchListAdapter = searchListAdapterEric(searchList)

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_eric)
        val firebaseFirestore: FirebaseFirestore = FirebaseFirestore.getInstance()

        //set recycler view
        search_list.hasFixedSize()
        search_list.layoutManager=LinearLayoutManager(this)
        search_list.adapter = searchListAdapter

        // On Text change search field
        search_field.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //get value of field
                val searchText:String = search_field.text.toString()

                //Search in Firestore
                searchInFireStore(searchText.toLowerCase())
            }

        })
    }


    private fun searchInFireStore(SearchText: String){
        //search Query
        firebaseFirestore.collection("Product").whereArrayContains("Search_Keywords",SearchText).get().addOnCompleteListener {
        //firebaseFirestore.collection("Product").orderBy("Product_Name").startAt(SearchText).endAt("$SearchText\uf8ff").get().addOnCompleteListener {

            if(it.isSuccessful){
                //Get the list and set it to adapter
                searchList = it.result!!.toObjects(searchModel::class.java)
                searchListAdapter.searchList = searchList
                searchListAdapter. notifyDataSetChanged()
            }else{
                //Log.d(TAG,"Error: ${it.exception!!.message}")
            }
        }
    }

}