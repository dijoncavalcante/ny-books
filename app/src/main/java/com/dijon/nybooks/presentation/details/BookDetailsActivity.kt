package com.dijon.nybooks.presentation.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dijon.nybooks.R
import com.dijon.nybooks.databinding.ActivityBookDetailsBinding
import com.dijon.nybooks.databinding.ActivityBooksBinding
import com.dijon.nybooks.presentation.base.BaseActivity

class BookDetailsActivity : BaseActivity() {

    lateinit var bindingDetails: ActivityBookDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingDetails = ActivityBookDetailsBinding.inflate(layoutInflater)
        setContentView(bindingDetails.root)

        setupToolbar(bindingDetails.layoutInclude.toolbarMain, R.string.books_details, true)

        val title = intent.getStringExtra(EXTRA_TITLE)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION)

        bindingDetails.bookDetailsTitle.text = title
        bindingDetails.bookDetailsDescription.text = description
    }

    companion object {
        private const val EXTRA_TITLE = "EXTRA_TITLE"
        private const val EXTRA_DESCRIPTION = "EXTRA_DESCRIPTION"

        fun getStartIntent(context: Context, title: String, description: String): Intent {
            return Intent(context, BookDetailsActivity::class.java).apply {
                putExtra(EXTRA_TITLE, title)
                putExtra(EXTRA_DESCRIPTION, description)
            }
        }
    }
}