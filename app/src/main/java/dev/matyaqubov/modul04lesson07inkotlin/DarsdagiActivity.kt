package dev.matyaqubov.modul04lesson07inkotlin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView

class DarsdagiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_darsdagi)

        val textView = findViewById<TextView>(R.id.textView)
        val text =
            "I know just how to #whister, And I know how to cry, I know just where to find the answer"

        val spannable: Spannable = SpannableString(text)
        spannable.setSpan(ForegroundColorSpan(Color.BLUE), 18, 27, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        textView.text = spannable
    }
}