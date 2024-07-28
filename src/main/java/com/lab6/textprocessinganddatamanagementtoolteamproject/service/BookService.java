package com.lab6.textprocessinganddatamanagementtoolteamproject.service;

import com.lab6.textprocessinganddatamanagementtoolteamproject.dao.BookDaoImpl;
import com.lab6.textprocessinganddatamanagementtoolteamproject.model.BookModel;

import java.util.HashSet;

public class BookService {
    BookDaoImpl bookDao = new BookDaoImpl();

    public HashSet<BookModel> getAll() {
        return bookDao.getBooks();
    }

    public BookModel get(int bookId) {
        return bookDao.getBook(bookId);
    }

    public void addBook(BookModel book) {
        bookDao.addBook(book);
    }

    public void updateBook(BookModel book) {
        bookDao.updateBook(book);
    }

    public void deleteBook(BookModel book) {
        bookDao.deleteBook(book);
    }
}