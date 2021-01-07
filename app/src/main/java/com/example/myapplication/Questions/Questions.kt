package com.example.myapplication.Questions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_questions.*
import kotlinx.android.synthetic.main.activity_recyclerview.*
import kotlinx.android.synthetic.main.questions_row.*

class Questions : AppCompatActivity() {

    lateinit var ref: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        ref = FirebaseDatabase.getInstance().getReference("Questions")
        println(ref)
        println("azazaz")

        val arrayList = ArrayList<Model>()
        arrayList.add(Model("first option"))
        arrayList.add(Model("second option"))
        arrayList.add(Model("third option"))
        arrayList.add(Model("fourth option"))

        val myAdapter = QuestionAdapter(arrayList,this)

        recyclerViewOptions.layoutManager = LinearLayoutManager(this)
        recyclerViewOptions.adapter = myAdapter


    }

    private fun sendData(){
        var options = answerSpace.text.trim()

    }




}