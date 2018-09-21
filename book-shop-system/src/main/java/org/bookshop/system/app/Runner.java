package org.bookshop.system.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.bookshop.system.app.enums.AgeRestriction;
import org.bookshop.system.app.enums.EditionType;
import org.bookshop.system.app.model.entity.Author;
import org.bookshop.system.app.model.entity.Book;
import org.bookshop.system.app.model.entity.Category;
import org.bookshop.system.app.service.AuthorService;
import org.bookshop.system.app.service.BookService;
import org.bookshop.system.app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private static final String AUTHORS_RESOURCE_FILE = System.getProperty("user.dir") +
            "/src/main/resources/" +
            "authors.txt";

    private static final String CATEGORIES_RESOURCE_FILE = System.getProperty("user.dir") +
            "/src/main/resources/" +
            "categories.txt";

    private static final String BOOKS_RESOURCE_FILE = System.getProperty("user.dir") +
            "/src/main/resources/" +
            "books.txt";

    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final BookService bookService;

    @Autowired
    public Runner(AuthorService authorService, CategoryService categoryService, BookService bookService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
//		initAuthors();
//		initCategories();
//		initBooks();

//		allBookstitleAfter2000y();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		allBookTitles(reader.readLine());
//		booksReleasedBefore(reader.readLine());

        deleteBooksByMinCopies(reader.readLine());
    }

//	public void testBookrepository() throws IOException {
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		System.out.println(bookRepository.getAllBooksTitleByAgeRestriction(reader.readLine()).size());
//	}

    private void initAuthors() throws IOException {
//		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(AUTHORS_RESOURCE_FILE))));

//		InputStream system = this.getClass().getResourceAsStream(AUTHORS_RESOURCE_FILE);
//		BufferedReader reader = new BufferedReader(new InputStreamReader(system));

        List<String> allAuthors = Files.readAllLines(Paths.get(AUTHORS_RESOURCE_FILE));

//		AgeRestriction restriction = AgeRestriction.valueOf(allAuthors.get(0));

        List<Author> listAuthors = allAuthors.stream().map(s -> {
            String[] authorNames = s.split("\\s+");
            return new Author(authorNames[0], authorNames[1]);
        }).collect(Collectors.toList());

        this.authorService.saveAuthorIntoDB(listAuthors);
    }

    private void initCategories() throws IOException {

        List<String> allCategories = Files.readAllLines(Paths.get(CATEGORIES_RESOURCE_FILE));
        List<Category> categoriesList = allCategories
                .stream()
                .filter(s -> !s.isEmpty()).map(s -> {
                    return new Category(s);
                }).collect(Collectors.toList());
        this.categoryService.saveCategoriesIntoDb(categoriesList);
    }

    private void initBooks() throws IOException, ParseException {
        Random random = new Random();
        List<String> allBooks = Files.readAllLines(Paths.get(BOOKS_RESOURCE_FILE));
        List<Author> authors = this.authorService.getAllAuthors();
        List<Book> books = new ArrayList<>();
        List<Category> categories = this.categoryService.getAll();

//		BufferedReader reader = new BufferedReader(new FileReader(BOOKS_RESOURCE_FILE));
//		String line = reader.readLine();
        for (String line : allBooks) {
//		while ((line = reader.readLine()) != null) {
            String[] data = line.split("\\s+");
//			int authorIndex = random.nextInt(Integer.parseInt(data[0]));
            int authorIndex = random.nextInt(authors.size());
            Author author = authors.get(authorIndex);
            int indexEditionType = Integer.parseInt(data[0]);
            EditionType[] editionTypes = EditionType.values();
            EditionType editionType = editionTypes[indexEditionType];
            SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
            Date releasDate = formatter.parse(data[1]);
            int copies = Integer.parseInt(data[2]);
            BigDecimal price = new BigDecimal(data[3]);
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
            StringBuffer titleBuilder = new StringBuffer();
            for (int i = 5; i < data.length; i++) {
                titleBuilder.append(data[i]).append(" ");
            }
            titleBuilder.delete(titleBuilder.lastIndexOf(" "), titleBuilder.lastIndexOf(" "));
            String title = titleBuilder.toString();

            Book book = new Book();
            book.setAuthor(author);
            book.setEditionType(editionType.toString());
            book.setReleasDate(releasDate);
//			book.setDescription(description);
            book.setCopies(copies);
            book.setPrice(price);
            book.setAgeRestriction(ageRestriction.toString());
            book.getCategories().add(categories.get(random.nextInt(categories.size())));
            book.setTitle(title);

            books.add(book);
        }

        this.bookService.saveIntoDB(books);
    }

    private void allBookstitleAfter2000y() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2000-01-01");
        List<String> test = this.bookService.allTitlesAfterYear(date);
        System.out.println(test);
//		Year year = Year.of(2000);
//		
//		long y = year.getLong(ChronoField.YEAR);
//		Date dt = new Date(y * 1000);

    }

    private void allBookTitles(String ageRestriction) {
        AgeRestriction ar = AgeRestriction.valueOf(ageRestriction.toUpperCase());
        this.bookService.getAllBooksTitleByAgeRestriction(ar).forEach(System.out::println);
        ;
    }

    private void booksReleasedBefore(String dateString) throws ParseException {
        Date beforeDate = new SimpleDateFormat("dd-MM-yyyy").parse(dateString);

        this.bookService.allBooksByReleaseDateBefore(beforeDate).forEach(System.out::println);
    }

    private void deleteBooksByMinCopies(String minCopies) {
        Integer min = Integer.parseInt(minCopies);

        long deleted = this.bookService.deleteAllBySomeNumber(min);

        System.out.printf("%d books were deleted", deleted);
    }
}
