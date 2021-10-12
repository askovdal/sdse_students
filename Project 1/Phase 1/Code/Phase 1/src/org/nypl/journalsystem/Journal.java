package org.nypl.journalsystem;

import java.util.List;

public class Journal {
	private String name;
	private Publisher publisher;
	private String issn;
	private List<Article> articles;

	public boolean isFullIssue() {
		return this.articles.size() >= 3;
	}
}
