package org.nypl.journalsystem;

import java.util.List;

public class Article {

    private int id;
    private String title;
    private List<Author> authors;

    public Article(int id, String title) {
        this.id = id;
        this.title = title;
    }
}
