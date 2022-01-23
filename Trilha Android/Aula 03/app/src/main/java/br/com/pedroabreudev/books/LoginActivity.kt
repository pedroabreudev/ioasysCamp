package br.com.pedroabreudev.books

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import com.google.android.material.button.MaterialButton

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val txtError = findViewById<AppCompatTextView>(R.id.textError)
        val button = findViewById<MaterialButton>(R.id.enterButton)

        button.setOnClickListener {
            txtError.visibility = View.VISIBLE

        }
    }
}