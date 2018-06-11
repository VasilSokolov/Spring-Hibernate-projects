package org.bookshop.system.app.service;

import java.util.Date;
import java.util.List;

import org.bookshop.system.app.model.entity.Book;

public interface BookService {

	void saveIntoDB(List<Book> books);
	
	List<String> allTitlesAfterYear(Date year);
}
