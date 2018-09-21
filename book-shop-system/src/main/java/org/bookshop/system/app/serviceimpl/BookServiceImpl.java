package org.bookshop.system.app.serviceimpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.bookshop.system.app.dto.book.BookReleasedDto;
import org.bookshop.system.app.enums.AgeRestriction;
import org.bookshop.system.app.model.entity.Book;
import org.bookshop.system.app.repositories.BookRepository;
import org.bookshop.system.app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final String appDomain;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository,
                           @Value(value = "${app.domain}") String appDomain) {
        this.bookRepository = bookRepository;
        this.appDomain = appDomain;
    }

    @PostConstruct
    public void printAppDomain() {
        System.out.println("App domain " + this.appDomain);
    }
//	@Autowired	
//	public BookServiceImpl(BookRepository bookRepository) {
//		this.bookRepository = bookRepository;
//	}	

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

    @Override
    public List<String> getAllBooksTitleByAgeRestriction(AgeRestriction ageRestriction) {
        return this.bookRepository.getAllBooksTitleByAgeRestriction(ageRestriction.toString());
    }

    @Override
    public List<BookReleasedDto> allBooksByReleaseDateBefore(Date beforeDate) {
        return this.bookRepository.findAllByReleasDateBefore(beforeDate)
                .stream()
                .map(b -> new BookReleasedDto(b.getTitle(), b.getEditionType(), b.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public long deleteAllBySomeNumber(Integer count) {
        return this.bookRepository.deleteAllByNumber(count);
    }

}
