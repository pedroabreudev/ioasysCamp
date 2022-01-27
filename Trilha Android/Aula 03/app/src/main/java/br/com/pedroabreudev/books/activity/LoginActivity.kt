package br.com.pedroabreudev.books.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import br.com.pedroabreudev.books.R
import com.google.android.material.button.MaterialButton

class LoginActivity : AppCompatActivity() {

    private val txtError: AppCompatTextView by lazy {
        findViewById(R.id.textError)
    }

    private val enterButton: MaterialButton by lazy {
        findViewById(R.id.enterButton)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        enterButton.setOnClickListener {
            val intent = Intent(this, BookListActivity::class.java)
            startActivity(intent)
        }
    }
}