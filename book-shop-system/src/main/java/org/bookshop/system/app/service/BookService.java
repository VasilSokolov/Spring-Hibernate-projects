package org.bookshop.system.app.service;

import java.util.Date;
import java.util.List;

import org.bookshop.system.app.dto.book.BookReleasedDto;
import org.bookshop.system.app.enums.AgeRestriction;
import org.bookshop.system.app.model.entity.Book;
import org.springframework.data.repository.query.Param;

public interface BookService {

    void saveIntoDB(List<Book> books);

    List<String> allTitlesAfterYear(Date year);

    List<String> getAllBooksTitleByAgeRestriction(AgeRestriction ageRestriction);

    List<BookReleasedDto> allBooksByReleaseDateBefore(Date beforeDate);

    long deleteAllBySomeNumber(Integer count);
}
