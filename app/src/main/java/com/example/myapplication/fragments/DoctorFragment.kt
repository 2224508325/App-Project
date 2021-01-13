package com.example.myapplication.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.EricActivity
import com.example.myapplication.R
import com.example.myapplication.Survey.UploadSurvey
import kotlinx.android.synthetic.main.fragment_doctor.*


class DoctorFragment : Fragment() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ericStart.setOnClickListener {
            val intent = Intent (activity, EricActivity::class.java)
            startActivity(intent)
        }
        AndyUploadButton.setOnClickListener {
            val intent = Intent (activity, UploadSurvey::class.java)
            startActivity(intent)
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater!!.inflate(R.layout.fragment_doctor, container, false)
    }


    
}


