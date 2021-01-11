package com.example.myapplication.Survey

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_question.*

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
        val head: List<Quiz>
        val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()

            firestore.collection("Head").whereEqualTo("title", "Red Eyes").get().addOnSuccessListener {
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