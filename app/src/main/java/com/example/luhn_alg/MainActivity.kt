package com.example.luhn_alg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var button: Button
    private lateinit var textViewRes: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inp: EditText = findViewById(R.id.editText)
        val out: TextView = findViewById(R.id.textViewRes)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val res = inp.text.toString().filter { it.isDigit() }.reversed().map { it.toString().toInt()}.toMutableList().mapIndexed() { index, c -> if ((index + 1) % 2 == 0) c * 2 else c }.map{it -> if(it > 9) (it/10) + (it%10) else it}.sum()
            if (res % 10 == 0) out.text = "True"
            else out.text = "False"
        }
    }
}