package org.bookshop.system.app.serviceimpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.bookshop.system.app.model.entity.Book;
import org.bookshop.system.app.repositories.BookRepository;
import org.bookshop.system.app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BookServiceImpl implements BookService{

	private final BookRepository bookRepository;
	
	@Autowired	
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}	

	@Override
	public void saveIntoDB(List<Book> books) {
		this.bookRepository.saveAll(books);
	}

	@Override
	public List<String> allTitlesAfterYear(Date year) {
		return this.bookRepository.findAllByReleasDateAfter(year)
				.stream()
				.map(b -> b.getTitle())
				.collect(Collectors.toList());
	}

}
