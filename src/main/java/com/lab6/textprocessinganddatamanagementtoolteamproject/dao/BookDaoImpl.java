package com.lab6.textprocessinganddatamanagementtoolteamproject.dao;

import com.lab6.textprocessinganddatamanagementtoolteamproject.dao.interfaces.BookDao;
import com.lab6.textprocessinganddatamanagementtoolteamproject.model.BookModel;

import java.awt.print.Book;
import java.util.HashSet;
import java.util.List;

public class BookDaoImpl implements BookDao {
    HashSet<BookModel> books = new HashSet<BookModel>();

    public HashSet<BookModel> getBooks() {
        return books;
    }

    public BookModel getBook(int bookId) {
        return books.stream().filter(val -> val.getBookID() == bookId).findFirst().get();
    }

    public void addBook(BookModel book) {
        if (books.isEmpty()) {
            books.add(new BookModel(0, book.getBookName()));
            return;
        }

        books.add(new BookModel(books.size(), book.getBookName()));
    }

    public void deleteBook(BookModel book) {
        books.remove(book);
    }

    public void updateBook(BookModel book) {
        books.add(book);
    }
}
