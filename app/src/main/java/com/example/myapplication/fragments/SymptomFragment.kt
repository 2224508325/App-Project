package com.example.myapplication.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.myapplication.R
import com.example.myapplication.Survey.MainHeadPainTypes
import com.example.myapplication.Survey.Quiz

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
        var BodyPart = " "

        head.setOnClickListener {
            val intent = Intent (activity, MainHeadPainTypes::class.java)
            intent.putExtra("BODYPART", "Head")
            myPainType.stuffDone = "Head"
            startActivity(intent)
        }
        upperbody.setOnClickListener {
            val intent = Intent (activity, MainHeadPainTypes::class.java)
            intent.putExtra("BODYPART", "UpperBody")
            myPainType.stuffDone = "UpperBody"
            startActivity(intent)
        }
        abdomen.setOnClickListener {
            val intent = Intent (activity, MainHeadPainTypes::class.java)
            intent.putExtra("BODYPART", "Abdomen")
            myPainType.stuffDone = "Abdomen"
            startActivity(intent)
        }
        pelvic.setOnClickListener {
            val intent = Intent (activity, MainHeadPainTypes::class.java)
            intent.putExtra("BODYPART", "Pelvic")
            myPainType.stuffDone = "Pelvic"
            startActivity(intent)
        }
        feet.setOnClickListener {
            val intent = Intent (activity, MainHeadPainTypes::class.java)
            intent.putExtra("BODYPART", "Limbs")
            myPainType.stuffDone = "Limbs"
            startActivity(intent)
        }
        left_hand.setOnClickListener {
            val intent = Intent (activity, MainHeadPainTypes::class.java)
            intent.putExtra("BODYPART", "Limbs")
            myPainType.stuffDone = "Limbs"
            startActivity(intent)
        }
        right_hand.setOnClickListener {
            val intent = Intent (activity, MainHeadPainTypes::class.java)
            intent.putExtra("BODYPART", "Limbs")
            myPainType.stuffDone = "Limbs"
            startActivity(intent)
        }
        super.onViewCreated(view, savedInstanceState)
    }
    class myPainType{
        companion object{
        var stuffDone = " "
        }
    }
}