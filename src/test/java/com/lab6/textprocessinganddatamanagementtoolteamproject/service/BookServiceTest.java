package com.lab6.textprocessinganddatamanagementtoolteamproject.service;

import com.lab6.textprocessinganddatamanagementtoolteamproject.dao.BookDaoImpl;
import com.lab6.textprocessinganddatamanagementtoolteamproject.model.BookModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    @Mock
    private BookDaoImpl bookDao;

    @InjectMocks
    private BookService bookService;

    private AutoCloseable mocks;

    @Before
    public void setUp() {
      mocks =  MockitoAnnotations.openMocks(this);
    }

    @After
    public void tearDown() throws Exception {
        mocks.close();
    }

    int bookId = 1;
    String bookName = "Book Name";


    @Test
    public void testGetAll() {
        HashSet<BookModel> books = new HashSet<>();
        when(bookDao.getBooks()).thenReturn(books);

        HashSet<BookModel> result = bookService.getAll();
        assertEquals(books, result);
        verify(bookDao, times(1)).getBooks();
    }

    @Test
    public void testGet() {

        BookModel book = new BookModel(bookId,bookName);
        when(bookDao.getBook(bookId)).thenReturn(book);

        BookModel result = bookService.get(bookId);
        assertEquals(book, result);
        verify(bookDao, times(1)).getBook(bookId);
    }

    @Test
    public void testGetNonExistingBook() {
        int bookId = 1;
        when(bookDao.getBook(bookId)).thenReturn(null);

        BookModel result = bookService.get(bookId);
        assertNull(result);
        verify(bookDao, times(1)).getBook(bookId);
    }

    @Test
    public void testAddBook() {
        BookModel book = new BookModel(bookId,bookName);
        doNothing().when(bookDao).addBook(book);

        bookService.addBook(book);
        verify(bookDao, times(1)).addBook(book);
    }

    @Test
    public void testUpdateBook() {
        BookModel book = new BookModel(bookId,bookName);
        doNothing().when(bookDao).updateBook(book);

        bookService.updateBook(book);
        verify(bookDao, times(1)).updateBook(book);
    }

    @Test
    public void testDeleteBook() {
        BookModel book = new BookModel(bookId,bookName);
        doNothing().when(bookDao).deleteBook(book);

        bookService.deleteBook(book);
        verify(bookDao, times(1)).deleteBook(book);
    }
}
