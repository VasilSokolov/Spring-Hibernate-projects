package org.bookshop.system.app.repositories;

import org.bookshop.system.app.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRository extends JpaRepository<Author, Long> {

//	@Query(value = "Select a from author where a.isDeleted = null")
//	@Override
//	default List<Author> findAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
//	@Query(value = "SELECT a FROM  Author as a where a.firstName=:firstName order by a.firstName desc")

//	@Query(value = "SELECT a FROM  Author as a left join a.books as b where b.title=:firstName ")
//	List<Author> findAllByFirstNameOrdered(@Param("firstName") String firstname);
//	List<Author> findAllByFirstNameOrderByFirstNameAsc(String firstname);
	
	
	//if we want to change something in db
	
}
