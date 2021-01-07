package com.example.myapplication.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.EricActivity
import com.example.myapplication.Questions.QuestionAdapter
import com.example.myapplication.Questions.Questions
import com.example.myapplication.R

import com.example.myapplication.retrieveActivity2
import kotlinx.android.synthetic.main.fragment_doctor.*
import kotlinx.android.synthetic.main.fragment_symptom.*

class SymptomFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_symptom, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        belly.setOnClickListener {
            val intent = Intent (activity, Questions::class.java)
            startActivity(intent)
        }
        super.onViewCreated(view, savedInstanceState)
    }
}