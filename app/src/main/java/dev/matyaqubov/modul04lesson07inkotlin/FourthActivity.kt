package dev.matyaqubov.modul04lesson07inkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class FourthActivity : AppCompatActivity() {
    private lateinit var buttonRegister: Button
    private lateinit var editTextUsername: EditText
    private  lateinit var editTextPassword:EditText
    private  lateinit var editTextConfirm:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)
        initViews()
    }

    private fun initViews() {
        buttonRegister = findViewById(R.id.btn_register)
        editTextUsername = findViewById(R.id.et_username)
        editTextPassword = findViewById<EditText>(R.id.et_password)
        editTextConfirm = findViewById<EditText>(R.id.et_confirm)
        val keycode = findViewById<View>(R.id.tv_keycode) as TextView
        editTextUsername.setOnKeyListener(View.OnKeyListener { view, i, keyEvent ->
            keycode.text = keyEvent.keyCode.toString()
            false
        })
        editTextUsername.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (charSequence.length >= 3) {
                    editTextPassword.setVisibility(View.VISIBLE)
                } else {
                    editTextPassword.setVisibility(View.GONE)
                }
            }

            override fun afterTextChanged(editable: Editable) {
                if (editable.length == 1) {
                    toast("OnKeyListener virtual divice'da ishlargan")
                }
            }
        })
        editTextPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (charSequence.length >= 3) {
                    editTextConfirm.setVisibility(View.VISIBLE)
                } else {
                    editTextConfirm.setVisibility(View.GONE)
                }
            }

            override fun afterTextChanged(editable: Editable) {}
        })
        editTextConfirm.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (charSequence.length >= 3) {
                    buttonRegister.setEnabled(true)
                } else {
                    buttonRegister.setEnabled(false)
                }
            }

            override fun afterTextChanged(editable: Editable) {}
        })
        buttonRegister.setOnClickListener(View.OnClickListener { check() })
    }

    private fun check() {
        if (editTextConfirm.getText().toString() == editTextPassword.getText().toString()) {
            toast("true")
        } else {
            toast("false")
        }
    }

    private fun toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}