package com.lab6.textprocessinganddatamanagementtoolteamproject.model;

public class BookModel {
    private int bookID;
    private String bookName;

    public BookModel(int bookID, String bookName) {
        this.bookID = bookID;
        this.bookName = bookName;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
