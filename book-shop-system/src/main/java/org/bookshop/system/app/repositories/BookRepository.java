package org.bookshop.system.app.repositories;

import java.util.Date;
import java.util.List;

import org.bookshop.system.app.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	List<Book> findAllByReleasDateAfter(Date releaseDate);
	
//	List<Book> findAllByAuthorage();
}
