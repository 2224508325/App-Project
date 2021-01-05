package com.example.myapplication

class Product (var pName:String){
    fun get() : String{
        return pName
    }
    fun set(s: String){
        this.pName = s
    }
}