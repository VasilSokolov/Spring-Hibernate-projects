package org.bookshop.system.app.service;

import java.util.List;

import org.bookshop.system.app.model.entity.Author;

public interface AuthorService {
	
	void saveAuthorIntoDB(Author author);
	void saveAuthorIntoDB(List<Author> authors);
	List<Author> getAllAuthors();
}
