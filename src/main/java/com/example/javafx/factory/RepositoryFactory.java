package com.example.javafx.factory;

import com.example.javafx.enums.RepoType;
import com.example.javafx.impls.BookRepository;
import com.example.javafx.impls.RentRepository;
import com.example.javafx.interfaces.IRepository;

public class RepositoryFactory {
    private RepositoryFactory(){
    }

    public static IRepository createRepository(RepoType type){
        switch (type){
            case BOOK: return new BookRepository();
            case RENT: return new RentRepository();
            default: throw new IllegalArgumentException("Thiếu tham số rồi");
        }
    }
}
