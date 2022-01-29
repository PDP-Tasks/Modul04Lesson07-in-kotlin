package dev.matyaqubov.modul04lesson07inkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var task1Button: Button? = null
    private  lateinit var task6Button:Button
    var task2Button: Button? = null
    private  lateinit var darsdagi:Button
    var task3Button: Button? = null
    var task4Button: Button? = null
    var task5Button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    open fun initViews() {
        darsdagi = findViewById<Button>(R.id.btn_darsdagi)
        task1Button = findViewById<Button>(R.id.btn_task1)
        task2Button = findViewById<Button>(R.id.btn_task2)
        task3Button = findViewById<Button>(R.id.btn_task3)
        task4Button = findViewById<Button>(R.id.btn_task4)
        task5Button = findViewById<Button>(R.id.btn_task5)
        task6Button = findViewById<Button>(R.id.btn_task6)
        task1Button!!.setOnClickListener(this)
        darsdagi.setOnClickListener(this)
        task2Button!!.setOnClickListener(this)
        task3Button!!.setOnClickListener(this)
        task4Button!!.setOnClickListener(this)
        task5Button!!.setOnClickListener(this)
        task6Button.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_darsdagi -> {
                val intent = Intent(this, DarsdagiActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_task1 -> {
                val intent = Intent(this, FirstActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_task2 -> {
                val intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_task3 -> {
                val intent = Intent(this, ThirdActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_task4 -> {
                val intent = Intent(this, FourthActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_task5 -> {
                val intent = Intent(this, FifthActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_task6 -> {
                val intent = Intent(this, SixthActivity::class.java)
                startActivity(intent)
            }
        }
    }
}