package br.com.pedroabreudev.camp

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i(TAG, "onCreate: Main ")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart: Main")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart: Main")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause: Main")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop: Main")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy: Main")
    }

}