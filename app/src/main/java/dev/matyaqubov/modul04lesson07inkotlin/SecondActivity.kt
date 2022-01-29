package dev.matyaqubov.modul04lesson07inkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val button = findViewById<Button>(R.id.btn_register)
        button.setOnClickListener { toast() }
    }

    private fun toast() {
        Toast.makeText(this, "simple ", Toast.LENGTH_SHORT).show()
    }
}