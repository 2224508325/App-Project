package com.example.myapplication.Survey

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.fragments.SymptomFragment
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main_head_pain_types.*
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
        OptionAdapter.recordresult.resultarray.clear()
    }

    private fun setUpEventListener() {
        var inttemp = OptionAdapter.recordintofposition.intposition
        val temp = OptionAdapter.recordresult.resultarray

        btnPrevious.setOnClickListener{


            inttemp --
            temp.removeAt(inttemp)
            index--
            val well = index
            bindViews()
            Log.d("FinalQuiz",temp.toString())
            Log.d("FinalQuiz", inttemp.toString())
            Log.d("FinalQuiz", well.toString())

        }
        btnNext.setOnClickListener{
            index++

            temp.add(OptionAdapter.recordposition.resultposition)
            inttemp ++
            bindViews()
            Log.d("FinalQuiz",temp.toString())
            Log.d("FinalQuiz", inttemp.toString())
        }
        btnSubmit.setOnClickListener{

            temp.add(OptionAdapter.recordposition.resultposition)
            Log.d("FinalQuiz",OptionAdapter.recordresult.resultarray.toString())
            OptionAdapter.recordresult.resultarray.clear()

            intent = Intent(this,IngredientPopup::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun setUpFirestore() {

        val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
        val pain:String? = intent.getStringExtra("PAIN")

        Log.d("last",SymptomFragment.myPainType.stuffDone)

            firestore.collection("Survey")
                .document("8OlHlFAdEH1hs0RTOV8L").collection(SymptomFragment.myPainType.stuffDone)
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