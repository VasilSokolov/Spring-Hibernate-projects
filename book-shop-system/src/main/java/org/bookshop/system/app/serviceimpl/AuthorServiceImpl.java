package org.bookshop.system.app.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.bookshop.system.app.model.entity.Author;
import org.bookshop.system.app.repositories.AuthorRository;
import org.bookshop.system.app.repositories.BookRepository;
import org.bookshop.system.app.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRository authorRository;
    private final BookRepository bookRepostory;

    @Autowired
    public AuthorServiceImpl(AuthorRository authorRository, BookRepository bookRepostory) {
        this.authorRository = authorRository;
        this.bookRepostory = bookRepostory;
    }


    @Override
    public void saveAuthorIntoDB(Author author) {
        this.authorRository.saveAndFlush(author);
    }


    @Override
    public void saveAuthorIntoDB(List<Author> authors) {
        this.authorRository.saveAll(authors);
    }


    @Override
    public List<Author> getAllAuthors() {
        return this.authorRository.findAll();
    }

}
