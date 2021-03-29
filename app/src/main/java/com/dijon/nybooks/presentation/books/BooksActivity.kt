package com.dijon.nybooks.presentation.books

import android.os.BaseBundle
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dijon.nybooks.R
import com.dijon.nybooks.data.model.Book
import com.dijon.nybooks.databinding.ActivityBooksBinding
import com.dijon.nybooks.presentation.base.BaseActivity
import com.dijon.nybooks.presentation.details.BookDetailsActivity

class BooksActivity : BaseActivity() {

    lateinit var binding: ActivityBooksBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBooksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar(binding.includeLayout.toolbarMain, R.string.books_title)

//        binding.includeLayout.toolbarMain.title = getString(R.string.books_title)
//        setSupportActionBar(binding.includeLayout.toolbarMain)

        val viewModel: BooksViewModel = ViewModelProviders.of(this).get(BooksViewModel::class.java)

        viewModel.booksLiveData.observe(this, Observer {
            it?.let { books ->
                with(binding.recyclerBooks) {
                    layoutManager =
                        LinearLayoutManager(this@BooksActivity, RecyclerView.VERTICAL, false)
                    setHasFixedSize(true)
                    adapter = BooksAdapter(books) { book ->
                        val intent = BookDetailsActivity.getStartIntent(
                            this@BooksActivity,
                            book.title,
                            book.description
                        )
                        this@BooksActivity.startActivity(intent)
                    }
                }
            }
        })
        viewModel.getBooks()
    }
}