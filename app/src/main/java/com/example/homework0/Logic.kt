package com.example.homework0

import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

data class Logic(val editName : EditText,val editLastName : EditText,val editAge : EditText) {
    val lines = arrayListOf<String>()
    fun showLines(textView: TextView){
        textView.text = ""
        for (item in lines)
            textView.text = textView.text.toString() + item
    }
}