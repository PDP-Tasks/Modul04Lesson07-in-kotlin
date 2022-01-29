package dev.matyaqubov.modul04lesson07inkotlin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import java.util.ArrayList

class FifthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth)
        initViews()
    }

    private fun initViews() {
        val text = "#I would #like to do #something similar to the #Twitter #app"
        setHashtag(text)
    }

    private fun setHashtag(text: String) {
        val textWithTag: Spannable = SpannableString(text)
        val indexes = findIndex(text)
        var i = 0
        while (i < indexes.size) {
            textWithTag.setSpan(
                ForegroundColorSpan(Color.GREEN),
                indexes[i], indexes[i + 1], Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            i += 2
        }
        val textViewTag = findViewById<TextView>(R.id.tv_Tag)
        textViewTag.text = textWithTag
    }

    private fun findIndex(text: String): ArrayList<Int> {
        val list = ArrayList<Int>()
        var i = 0
        var space = 0
        while (i != -1) {
            i = text.indexOf('#', space)
            if (i != -1) {
                list.add(i)
                space = text.indexOf(' ', i)
                if (space == -1) {
                    space = text.length
                }
                list.add(space)
            }
        }
        return list
    }
}