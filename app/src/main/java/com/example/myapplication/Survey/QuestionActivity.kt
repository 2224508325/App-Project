package com.example.myapplication.Survey

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_question.*
import org.w3c.dom.Text

class QuestionActivity : AppCompatActivity() {

    var quizzes : MutableList<Quiz>? = null
    var questions:MutableMap<String,Question>? = null
    var index = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        setUpFirestore()
        setUpEventListener()
    }

    private fun setUpEventListener() {
        btnPrevious.setOnClickListener{
            index--
            bindViews()
        }
        btnNext.setOnClickListener{
            index++
            bindViews()
        }
        btnSubmit.setOnClickListener{
            Log.d("FinalQuiz",questions.toString())
        }
    }

    private fun setUpFirestore() {

        val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
        var pain:String? = intent.getStringExtra("PAIN")
        var BodyPart:String? = intent.getStringExtra("BODYPART")
        Log.d("body",BodyPart.toString())

            firestore.collection("Survey").document("8OlHlFAdEH1hs0RTOV8L").collection(BodyPart.toString())
                    .whereEqualTo("title", pain).get().addOnSuccessListener {
                if(it != null && !it.isEmpty){
                    quizzes = it.toObjects(Quiz::class.java)
                    questions = quizzes!![0].questions
                    bindViews()
            }
        }
    }

    private fun bindViews() {
        btnPrevious.visibility = View.GONE
        btnSubmit.visibility = View.GONE
        btnNext.visibility = View.GONE

        if(index == 1){
            btnNext.visibility = View.VISIBLE
        }else if(index == questions!!.size){
            btnSubmit.visibility = View.VISIBLE
            btnPrevious.visibility = View.VISIBLE
        } else{
            btnPrevious.visibility = View.VISIBLE
            btnNext.visibility = View.VISIBLE

        }


        val question = questions!!["question$index"]
        question?.let {

            Description.text = it.description
            val optionAdapter = OptionAdapter(this, it)
            optionList.layoutManager = LinearLayoutManager(this)
            optionList.adapter = optionAdapter
            optionList.setHasFixedSize(true)
        }
    }
}