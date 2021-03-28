package com.dijon.nybooks.presentation.books

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dijon.nybooks.R
import com.dijon.nybooks.data.model.Book
import com.dijon.nybooks.databinding.ActivityBooksBinding

class BooksActivity : AppCompatActivity() {

    lateinit var binding: ActivityBooksBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBooksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbarMain.title = getString(R.string.books_title)
        setSupportActionBar(binding.toolbarMain)

        with(binding.recyclerBooks) {
            layoutManager = LinearLayoutManager(this@BooksActivity, RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
            adapter = BooksAdapter(getBooks())
        }
    }

    private fun getBooks(): List<Book> {
        return listOf(
                Book("Primeiro Livro", "Dijon 1"),
                Book("Segundo Livro", "Dijon 2"),
                Book("Terceiro Livro", "Dijon 3"),
                Book("Quarto Livro", "Dijon 51")
                )
    }
}