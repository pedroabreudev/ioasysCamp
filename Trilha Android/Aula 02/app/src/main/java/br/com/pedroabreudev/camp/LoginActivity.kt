package br.com.pedroabreudev.camp

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val button = findViewById<Button>(R.id.button)

        button.apply {
            setOnClickListener {
                startActivity(Intent(context, MainActivity::class.java))
            }
        }

        Log.i(TAG, "onCreate: Login")

    }

    override fun onStart() {
        super.onStart()
        Log.i(ContentValues.TAG, "onStart: Login")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(ContentValues.TAG, "onRestart: Login")
    }

    override fun onPause() {
        super.onPause()
        Log.i(ContentValues.TAG, "onPause: Login")
    }

    override fun onStop() {
        super.onStop()
        Log.i(ContentValues.TAG, "onStop: Login")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(ContentValues.TAG, "onDestroy: Login")
    }
}