package com.devahoy.learn30androidlibraries.day21;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Book")
public class Book extends Model{

    public Book() {
        super();
    }
    public Book(String title, String author, String publisher, String date) {
        super();
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.releaseDate = date;
    }

    @Column(name = "title")
    public String title;

    @Column(name = "author")
    public String author;

    @Column(name = "publisher")
    public String publisher;

    @Column(name = "release_date")
    public String releaseDate;

}
