package com.suvai.tictoctoy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        startActivity(Intent(this@ResultActivity, MainActivity::class.java))
    }
    override fun onPause() {
        super.onPause()
        finish()
    }
}