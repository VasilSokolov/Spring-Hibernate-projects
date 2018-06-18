package org.bookshop.system.app.repositories;

import java.util.Date;
import java.util.List;

import org.bookshop.system.app.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	List<Book> findAllByReleasDateAfter(Date releaseDate);
	
//	List<Book> findAllByTitleAgeRestriction
	@Query(value = "SELECT b.title FROM Book As b where b.ageRestriction=:rest")
	List<String> getAllBooksTitleByAgeRestriction(@Param("rest")String ageRestriction);
//	List<Book> findAllByAuthorage();
	
	List<Book> findAllByReleasDateBefore(Date date);

	@Modifying
	@Query(value = "delete from Book as b where b.copies<:copyCount")
	int deleteAllByNumber(@Param("copyCount")Integer minCopiesCount);
}
