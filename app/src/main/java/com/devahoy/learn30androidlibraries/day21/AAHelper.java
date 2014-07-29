package com.devahoy.learn30androidlibraries.day21;

import com.activeandroid.query.Select;

import java.util.List;

/**
 * AA stand for ActiveAndroid :D
 * This class use for helper method ex. create, read, update, delete.
 */
public class AAHelper {

    public static List<Book> findBooks() {
        return new Select()
                .from(Book.class)
                .execute();
    }

    public static Book findBookById(long id) {
        return new Select()
                .from(Book.class)
                .where("_id = ?", String.valueOf(id))
                .executeSingle();
    }

}
