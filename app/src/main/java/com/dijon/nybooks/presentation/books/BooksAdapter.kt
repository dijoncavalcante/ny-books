package com.dijon.nybooks.presentation.books

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.dijon.nybooks.data.model.Book
import com.dijon.nybooks.databinding.ItemBookBinding

class BooksAdapter(
        private val books: List<Book>,
        val onItemClickListener: ((book : Book) -> Unit)
) : RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val itemViewBinding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BooksViewHolder(itemViewBinding, onItemClickListener)
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.bindView(books[position])
    }

    override fun getItemCount() = books.count()

    class BooksViewHolder(
        itemViewBinding: ItemBookBinding,
        private val onItemClickListener: ((book : Book) -> Unit)
    ) : RecyclerView.ViewHolder(itemViewBinding.root) {
        private val title = itemViewBinding.textTitle
        private val author = itemViewBinding.textAuthor

        fun bindView(book: Book) {
            title.text = book.title
            author.text = book.author

            itemView.setOnClickListener{
                onItemClickListener.invoke(book)
            }
        }
    }
}