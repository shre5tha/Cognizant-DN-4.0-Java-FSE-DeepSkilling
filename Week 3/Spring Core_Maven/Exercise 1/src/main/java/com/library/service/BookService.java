package com.library.service;
import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepo;

    public void setBookRepository(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    public void addBook(String bookName) {
        System.out.println("Adding book: " + bookName);
        bookRepo.saveBook(bookName);
    }
}
