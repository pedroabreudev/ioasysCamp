package br.com.pedroabreudev.books.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import br.com.pedroabreudev.books.R
import br.com.pedroabreudev.books.adapter.BookListAdapter
import br.com.pedroabreudev.books.model.Book

class BookListActivity : AppCompatActivity() {

    private lateinit var bookListAdapter: BookListAdapter

    private val rvBooks: RecyclerView by lazy {
        findViewById(R.id.rvBooks)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)
        setBookListData()
    }

    private fun setBookListData() {
        bookListAdapter = BookListAdapter()
        rvBooks.adapter = bookListAdapter

        bookListAdapter.submitList(Book.getMockList())
    }


}