package com.dijon.nybooks.presentation.books

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dijon.nybooks.data.model.Book

class BooksViewModel : ViewModel() {

    val booksLiveData: MutableLiveData<List<Book>> = MutableLiveData()

    fun getBooks() {
        booksLiveData.value = createFakeBooks()
    }

    fun createFakeBooks(): List<Book> {
        return listOf(
            Book("Primeiro Livro", "Dijon 1"),
            Book("Segundo Livro", "Dijon 2"),
            Book("Terceiro Livro", "Dijon 3"),
            Book("Quarto Livro", "Dijon 51")
        )
    }
}