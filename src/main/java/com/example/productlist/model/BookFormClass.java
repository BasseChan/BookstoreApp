package com.example.productlist.model;

import com.example.productlist.domain.*;
import com.example.productlist.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Objects;

public class BookFormClass {
    private String categories;
    private String categoriesPrev;
    private String authors;
    private String authorsPrev;
    private float price;
    private Book book;

    public BookFormClass(String categories, String categoriesPrev, String authors, String authorsPrev, float price, Book book) {
        this.categories = categories;
        this.categoriesPrev = categoriesPrev;
        this.authors = authors;
        this.authorsPrev = authorsPrev;
        this.price = price;
        this.book = book;
    }

    public BookFormClass(Book book) {
        this.book = book;
    }

    public BookFormClass() {
        this.categories = "";
        this.authors = "";
        this.book = new Book();
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getCategoriesPrev() {
        return categoriesPrev;
    }

    public void setCategoriesPrev(String categoriesPrev) {
        this.categoriesPrev = categoriesPrev;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getAuthorsPrev() {
        return authorsPrev;
    }

    public void setAuthorsPrev(String authorsPrev) {
        this.authorsPrev = authorsPrev;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
