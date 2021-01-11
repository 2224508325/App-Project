package com.example.myapplication.Survey

data class Quiz (
    var title: String = " ",
    var questions: MutableMap<String, Question> = mutableMapOf()
)