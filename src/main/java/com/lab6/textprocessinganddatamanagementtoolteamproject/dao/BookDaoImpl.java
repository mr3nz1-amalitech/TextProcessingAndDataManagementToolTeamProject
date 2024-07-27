package com.lab6.textprocessinganddatamanagementtoolteamproject.dao;

import com.lab6.textprocessinganddatamanagementtoolteamproject.dao.interfaces.BookDao;
import com.lab6.textprocessinganddatamanagementtoolteamproject.model.BookModel;

import java.util.HashSet;
import java.util.List;

public class BookDaoImpl implements BookDao {
    HashSet<BookModel> books = new HashSet<BookModel>();

    public HashSet<BookModel> getBookModels() {
        return books;
    }

    public void addBook(BookModel book) {
        books.add(book);
    }

    public void deleteBook(BookModel book) {
        books.remove(book);
    }

    public void updateBook(BookModel book) {
        books.add(book);
    }
}
