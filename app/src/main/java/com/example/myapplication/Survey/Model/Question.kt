package com.example.myapplication.Survey.Model

data class Question (
    var description : String = " ",
    var option1 : String = " ",
    var option2 : String = " ",
    var option3 : String = " ",
    var option4 : String = " ",
    var option5 : String = " ",
    var userAnswer:String = "",
    var rating:String = ""
)
