package com.example.javafx.interfaces;

import java.util.ArrayList;

public interface IBookRepository<Book> {
    ArrayList<Book> all();
    boolean create(Book book);
    boolean update(Book book);
    boolean delete(Book book);
    Book findOne(Integer id);
}
