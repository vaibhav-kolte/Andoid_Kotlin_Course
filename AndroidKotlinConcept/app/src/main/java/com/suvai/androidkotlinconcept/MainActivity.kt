package com.suvai.androidkotlinconcept

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnToastSnckbar: Button = findViewById(R.id.btnToastSnackbar)
        btnToastSnckbar.setOnClickListener {
            startActivity(
                Intent(this@MainActivity,ToastSnckbarActivity::class.java)
            )
        }

    }
}