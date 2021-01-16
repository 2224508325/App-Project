package com.example.myapplication.Survey.Model

data class Quiz (
    var title: String = " ",
    var questions: MutableMap<String, Question> = mutableMapOf()
)