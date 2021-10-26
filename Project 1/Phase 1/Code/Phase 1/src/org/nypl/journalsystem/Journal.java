package org.nypl.journalsystem;

import java.util.List;

public class Journal {

    private String issn;
    private String name;
    private Publisher publisher;
    private List<Article> articles;

    public Journal(String issn, String name, Publisher publisher) {
        this.issn = issn;
        this.name = name;
        this.publisher = publisher;
    }

    public boolean isFullIssue() {
        return this.articles.size() >= 3;
    }
}
