package org.nypl.journalsystem;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {
    private List<Journal> journals;

    public LibrarySystem() throws FileNotFoundException, IOException {
        // TODO: Initialize system with default journals
        File file = new File("data/Journals.csv");
        Reader in = new FileReader(file);

        Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);

        journals = new ArrayList<Journal>();
        for (CSVRecord record : records) {
            if (record.getRecordNumber() == 1) {
                continue;
            }

            System.out.println(record.toString());

            Journal journal = new Journal(record.get(0));
            journals.add(journal);
        }

        System.out.println(journals);
    }

    public void load() throws FileNotFoundException, IOException {
        loadAuthors();
        loadArticles();
    }

    protected void loadAuthors() throws FileNotFoundException, IOException {
        File file = new File("data/Authors.csv");

        // TODO: Load authors from file
    }

    protected void loadArticles() throws FileNotFoundException, IOException {
        File file = new File("data/Articles.csv");

        // TODO: Load articles from file and assign them to appropriate journal
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
