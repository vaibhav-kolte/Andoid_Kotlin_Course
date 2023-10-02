package com.suvai.androidkotlinconcept

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class ToastSnckbarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast_snckbar)
        val btnToastMessage: Button = findViewById(R.id.btnToastMessage)
        val btnSnackbar: Button = findViewById(R.id.btnSnackbar)
        btnToastMessage.setOnClickListener {
            showToast(getString(R.string.welcome_to_my_kotlin_course))
        }
        btnSnackbar.setOnClickListener {
            showSnackbar(getString(R.string.welcome_to_snackbar))
        }
    }

    private fun showSnackbar(message: String) {
        val snackbar = Snackbar.make(
            findViewById(R.id.btnToastMessage),
            message,
            Snackbar.LENGTH_LONG
        ).setAction(getString(R.string.btnOK)) { showToast(getString(R.string.ok_button_clicked)) }
        snackbar.show()
    }

    private fun showToast(message: String) {
        Toast.makeText(this@ToastSnckbarActivity, message, Toast.LENGTH_SHORT)
            .show()
    }
}