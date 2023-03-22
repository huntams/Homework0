package com.example.homework0

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private fun showToast(name: String) {

        Toast.makeText(applicationContext, "Поле $name пустое", Toast.LENGTH_SHORT).show()
    }

    private fun showSnackbar(it: View, info: String) {
        Snackbar.make(it, info, Snackbar.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonAdd = findViewById<Button>(R.id.buttonAdd)
        val buttonRemove = findViewById<Button>(R.id.buttonRemove)
        val logic = Logic(
            findViewById<EditText>(R.id.editTextName),
            findViewById<EditText>(R.id.editTextLastName),
            findViewById<EditText>(R.id.editTextAge)
        )
        val textView = findViewById<TextView>(R.id.textView)
        buttonAdd.setOnClickListener {
            if (logic.lines.size == 10)
                showSnackbar(it, "Список заполнен")
            else {
                when {
                    logic.editName.text.isEmpty() -> showToast(logic.editName.hint.toString())
                    logic.editLastName.text.isEmpty() -> showToast(logic.editLastName.hint.toString())
                    logic.editAge.text.isEmpty() -> showToast(logic.editAge.hint.toString())
                    else -> {
                        val line =
                            "Имя = ${logic.editName.text} Фамилия = ${logic.editLastName.text}, Возраст = ${logic.editAge.text}\n"
                        logic.lines.add(line)
                        logic.showLines(textView)
                    }
                }
            }
        }
        buttonRemove.setOnClickListener {
            if (logic.lines.size == 0)
                showSnackbar(it, "Список пуст")
            else {
                logic.lines.removeLast()
                logic.showLines(textView)
            }

        }
    }
}