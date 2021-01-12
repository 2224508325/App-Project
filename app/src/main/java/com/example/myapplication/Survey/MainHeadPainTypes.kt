package com.example.myapplication.Survey

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.MainThread
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.R
import com.google.firebase.firestore.FirebaseFirestore

import kotlinx.android.synthetic.main.activity_main_head_pain_types.*


class MainHeadPainTypes : AppCompatActivity() {

    lateinit var adapter: QuizAdapter
    private var quizList = mutableListOf<Quiz>()
    lateinit var firestore:FirebaseFirestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_head_pain_types)

        setUpFireStore()
        setUpRecyclerView()
    }


    private fun setUpFireStore() {

        firestore = FirebaseFirestore.getInstance()
        var BodyPart:String? = intent.getStringExtra("BODYPART")

        PAINTYPE.text = BodyPart.toString()

        Log.d("asas",BodyPart.toString())


        Toast.makeText(this,BodyPart.toString(),Toast.LENGTH_SHORT).show()
        val collectionReference = firestore.collection("Survey").document("8OlHlFAdEH1hs0RTOV8L").collection(BodyPart.toString())
        collectionReference.addSnapshotListener{value,error->
             if(value == null || error != null){
                 Toast.makeText(this,"Error fetching data",Toast.LENGTH_SHORT).show()
                 return@addSnapshotListener
             }
            Log.d("Data", value.toObjects(Quiz::class.java).toString())
            quizList.clear()
            quizList.addAll(value.toObjects(Quiz::class.java))
            adapter.notifyDataSetChanged()
        }
    }

    private fun setUpRecyclerView() {
        adapter = QuizAdapter(this,quizList)
        quizRecyclerView.layoutManager = GridLayoutManager(this,2)
        quizRecyclerView.adapter = adapter
    }
}