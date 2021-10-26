package org.nypl.journalsystem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class LibrarySystem {

    private List<Publisher> publishers;
    private List<Journal> journals;
    private List<Author> authors;
    private List<Article> articles;

    private CSVFormat format = CSVFormat.RFC4180
        .withFirstRecordAsHeader()
        .withIgnoreSurroundingSpaces();

    public LibrarySystem() throws FileNotFoundException, IOException {
        File file = new File("data/Journals.csv");
        Reader in = new FileReader(file);

        Iterable<CSVRecord> records = format.parse(in);

        publishers = new ArrayList<>();
        journals = new ArrayList<>();
        for (CSVRecord record : records) {
            Publisher publisher = new Publisher(
                record.get("Publisher"),
                record.get("Location")
            );

            if (
                publishers
                    .stream()
                    .noneMatch(p -> p.getName().equals(publisher.getName()))
            ) {
                publishers.add(publisher);
            }

            Journal journal = new Journal(
                record.get("ISSN"),
                record.get("Name"),
                publisher
            );

            journals.add(journal);
        }
    }

    public void load() throws FileNotFoundException, IOException {
        loadAuthors();
        loadArticles();
    }

    protected void loadAuthors() throws FileNotFoundException, IOException {
        File file = new File("data/Authors.csv");
        Reader in = new FileReader(file);

        Iterable<CSVRecord> records = format.parse(in);

        authors = new ArrayList<>();
        for (CSVRecord record : records) {
            Author author = new Author(
                Integer.parseInt(record.get("ID")),
                record.get("Name")
            );

            authors.add(author);
        }
    }

    protected Author getAuthor(int id) {
        for (Author author : authors) {
            if (author.getId() == id) {
                return author;
            }
        }
        return null;
    }

    protected void loadArticles() throws FileNotFoundException, IOException {
        File file = new File("data/Articles.csv");
        Reader in = new FileReader(file);

        Iterable<CSVRecord> records = format.parse(in);

        articles = new ArrayList<>();
        for (CSVRecord record : records) {
            // TODO: Loop through article's authors and add them to the article
            //  object
            Author author = getAuthor(3);

            Article article = new Article(
                Integer.parseInt(record.get("ID")),
                record.get("Title")
            );

            articles.add(article);
            // TODO: Assign article to the appropriate journal
        }
    }

    public void listContents() {
        // TODO: Print all journals with their respective articles and authors to the
        // console.
    }

    public static final void main(String[] args) throws Exception {
        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.load();
        librarySystem.listContents();
    }
}
