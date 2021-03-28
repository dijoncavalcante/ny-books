package com.dijon.nybooks.presentation.books

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dijon.nybooks.R
import com.dijon.nybooks.databinding.ActivityBooksBinding

class BooksActivity : AppCompatActivity() {

    lateinit var binding: ActivityBooksBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBooksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbarMain.title = getString(R.string.books_title)
        setSupportActionBar(binding.toolbarMain)
    }
}