package com.example.myapplication

import java.util.*

class ProductList(
    var Plist: Array<String> = emptyArray()
){ fun get() : Array<String>{
    return Plist
}

    fun addList(Pname:String){
        Plist = append(Plist,Pname)
    }

    fun append(arr: Array<String>, element: String): Array<String> {
        val list: MutableList<String> = arr.toMutableList()
        list.add(element)
        return list.toTypedArray()
    }
    fun displayPlist(){
        println(Arrays.toString(Plist))
    }

}