package dev.matyaqubov.modul04lesson07inkotlin

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.webkit.URLUtil
import android.widget.TextView

class SixthActivity : AppCompatActivity() {
    private var context: Context? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sixth)
        context = this
        initViews()
    }

    private fun initViews() {
        val text = "I would like to do something similar to the https://twitter.com app"
        setURL(text)
    }

    private fun setURL(text: String) {
        val spannable: Spannable = SpannableString(text)
        val str = text.split(" ").toTypedArray()
        for (s in str) {
            if (URLUtil.isValidUrl(s)) {
                spannable.setSpan(object : ClickableSpan() {
                    override fun onClick(view: View) {
                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.data = Uri.parse(s)
                        startActivity(intent)
                    }

                    override fun updateDrawState(ds: TextPaint) {
                        ds.color = Color.BLUE
                        ds.isUnderlineText = true
                    }
                }, text.indexOf(s), text.indexOf(s) + s.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
        }
        val textViewUrl = findViewById<TextView>(R.id.tv_link)
        textViewUrl.movementMethod = LinkMovementMethod()
        textViewUrl.text = spannable
    }

}