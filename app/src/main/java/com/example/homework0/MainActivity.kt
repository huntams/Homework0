package com.example.homework0

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    fun toastShow(name: String) {
        Toast.makeText(applicationContext, "Поле $name пустое", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonAdd = findViewById<Button>(R.id.ButtonAdd)
        val buttonRemove = findViewById<Button>(R.id.ButtonRemove)
        val editName = findViewById<EditText>(R.id.editTextName)
        val editLastName = findViewById<EditText>(R.id.editTextLastName)
        val editAge = findViewById<EditText>(R.id.editTextAge)
        val textView = findViewById<TextView>(R.id.textView)
        val lines = arrayListOf<String>()
        textView.movementMethod = ScrollingMovementMethod()
        buttonAdd.setOnClickListener {
            if (lines.size + 1 == 10)
                Snackbar.make(it, "Список заполнен", Snackbar.LENGTH_SHORT).show()
            else {
                when {
                    editName.text.isEmpty() -> toastShow(editName.hint.toString())
                    editLastName.text.isEmpty() -> toastShow(editLastName.hint.toString())
                    editAge.text.isEmpty() -> toastShow(editAge.hint.toString())
                    else -> {
                        textView.text = ""
                        val line =
                            "Имя = ${editName.text} Фамилия = ${editLastName.text}, Возраст = ${editAge.text}\n"
                        lines.add(line)
                        for (item in lines)
                            textView.text = textView.text.toString() + item
                    }
                }
            }
        }
        buttonRemove.setOnClickListener {
            if (lines.size == 0)
                Snackbar.make(it, "Список пуст", Snackbar.LENGTH_SHORT).show()
            else {
                lines.removeLast()
                textView.text = ""
                for (item in lines)
                    textView.text = textView.text.toString() + item
            }

        }
    }
}