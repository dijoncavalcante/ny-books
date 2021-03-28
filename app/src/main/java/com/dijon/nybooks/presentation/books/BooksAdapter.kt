package com.dijon.nybooks.presentation.books

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dijon.nybooks.data.model.Book
import com.dijon.nybooks.databinding.ItemBookBinding

class BooksAdapter(
        private val books: List<Book>,
) : RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val itemViewBinding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BooksViewHolder(itemViewBinding)
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.bindView(books[position])
    }

    override fun getItemCount() = books.count()

    class BooksViewHolder(itemViewBinding: ItemBookBinding) : RecyclerView.ViewHolder(itemViewBinding.root) {
        private val title = itemViewBinding.textTitle
        private val author = itemViewBinding.textAuthor

        fun bindView(book: Book) {
            title.text = book.title
            author.text = book.author

        }
    }
}