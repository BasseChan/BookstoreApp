package com.example.productlist.services;

import com.example.productlist.domain.*;
import com.example.productlist.model.BookFormClass;
import com.example.productlist.model.PriceFormClass;
import com.example.productlist.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@org.springframework.stereotype.Service
public class CatalogService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    Author_BookRepository author_bookRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    Category_BookRepository category_bookRepository;
    @Autowired
    PriceRepository priceRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getAllOfferedBooks() {
        List<Book> books = bookRepository.findAll();
        List<Book> offered = new ArrayList<>();
        for (Book book : books) {
            if (book.getInOffer()) {
                offered.add(book);
            }
        }
        return offered;
    }

    public Book getBookById(long id) {
        var value= bookRepository.findById(id);
        return value.isEmpty()?null:value.get();
    }

    public void addNewBook(Book newBook) {
        bookRepository.save(newBook);
    }

    public Category getOrCreateCategoryByName(String name) {
        for (Category category : categoryRepository.findAll()) {
            if (Objects.equals(category.getCategoryName(), name)) {
                return category;
            }
        }
        Category category = Category.builder()
                .categoryName(name)
                .build();
        categoryRepository.save(category);
        return category;
    }

    public void categoriesToDatabase(BookFormClass book) {
        String[] categoriesSeparate = book.getCategories().split("\\r?\\n", -1);
        for (String category : categoriesSeparate) {
            if(!Objects.equals(category, "")) {
                Category_Book category_book = Category_Book.builder()
                        .bookInCategory_Book(book.getBook())
                        .categoryInCategory_Book(getOrCreateCategoryByName(category))
                        .build();
                category_bookRepository.save(category_book);
            }
        }
    }

    public List<Category_Book> getCategory_BookByBook(Book book) {
        List<Category_Book> list = new ArrayList<>();
        List<Category_Book> fullList = category_bookRepository.findAll();
        for (Category_Book category_book : fullList) {
            if (Objects.equals(category_book.getBookInCategory_Book().getId(), book.getId())) {
                list.add(category_book);
            }
        }
        return list;
    }

    public void removeCategoryBook(Book book, String categoryName) {
        List<Category_Book> category_bookList = getCategory_BookByBook(book);
        for (Category_Book category_book : category_bookList) {
            if (Objects.equals(category_book.getCategoryInCategory_Book().getCategoryName(), categoryName)) {
                category_bookRepository.delete(category_book);
            }
        }
    }
    public void addCategoryBook(Book book, String categoryName) {
        Category category = getOrCreateCategoryByName(categoryName);
        Category_Book category_book = Category_Book.builder()
                .bookInCategory_Book(book)
                .categoryInCategory_Book(category)
                .build();
        category_bookRepository.save(category_book);
    }
    public void updateCategories(BookFormClass bookFormClass) {
        Book book = bookFormClass.getBook();
        List<String> before = Arrays.asList(bookFormClass.getCategoriesPrev().split("\\r?\\n", -1));
        List<String> now = Arrays.asList(bookFormClass.getCategories().split("\\r?\\n", -1));
        for (String categoryName : before) {
            if (!now.contains(categoryName)) {
                removeCategoryBook(book, categoryName);
            }
        }
        for (String categoryName : now) {
            if (!before.contains(categoryName)) {
                addCategoryBook(book, categoryName);
            }
        }
    }

    public Author getOrCreateAuthorByFullName(String fullName) {
        for (Author author : authorRepository.findAll()) {
            if (Objects.equals(author.getFullName(), fullName)) {
                return author;
            }
        }
        Author author = Author.builder().build();
        author.setFullName(fullName);
        authorRepository.save(author);
        return author;
    }

    public void authorsToDatabase(BookFormClass newBook) {
        String[] authorsSeparate = newBook.getAuthors().split("\\r?\\n", -1);
        for (String author : authorsSeparate) {
            Author_Book author_book = Author_Book.builder()
                    .bookInAuthor_Book(newBook.getBook())
                    .authorInAuthor_Book(getOrCreateAuthorByFullName(author))
                    .build();
            author_bookRepository.save(author_book);
        }
    }

    public List<Author_Book> getAuthor_BookByBook(Book book) {
        List<Author_Book> list = new ArrayList<>();
        List<Author_Book> fullList = author_bookRepository.findAll();
        for (Author_Book author_book : fullList) {
            if (Objects.equals(author_book.getBookInAuthor_Book().getId(), book.getId())) {
                list.add(author_book);
            }
        }
        return list;
    }

    public void removeAuthorBook(Book book, String authorName) {
        List<Author_Book> author_bookList = getAuthor_BookByBook(book);
        for (Author_Book author_book : author_bookList) {
            if (Objects.equals(author_book.getAuthorInAuthor_Book().getFullName(), authorName)) {
                author_bookRepository.delete(author_book);
            }
        }
    }
    public void addAuthorBook(Book book, String authorName) {
        Author author = getOrCreateAuthorByFullName(authorName);
        Author_Book author_book = Author_Book.builder()
                .bookInAuthor_Book(book)
                .authorInAuthor_Book(author)
                .build();
        author_bookRepository.save(author_book);
    }
    public void updateAuthors(BookFormClass bookFormClass) {
        Book book = bookFormClass.getBook();
        List<String> before = Arrays.asList(bookFormClass.getAuthorsPrev().split("\\r?\\n", -1));
        List<String> now = Arrays.asList(bookFormClass.getAuthors().split("\\r?\\n", -1));
        for (String authorName : before) {
            if (!now.contains(authorName)) {
                removeAuthorBook(book, authorName);
            }
        }
        for (String authorName : now) {
            if (!before.contains(authorName)) {
                addAuthorBook(book, authorName);
            }
        }
    }

    public void priceForNewBook(BookFormClass newBook) {
        Price startPrice = Price.builder()
                .value(newBook.getPrice())
                .bookInPrice(newBook.getBook())
                .atDiscount(false)
                .dateFrom(new Date())
                .build();
        priceRepository.save(startPrice);
    }

    public void deleteBookById(long id) {
        Book book = getBookById(id);
        book.setInOffer(false);
        bookRepository.save(book);
    }

    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    public void addNewPrice(Price price) {
        Book book = price.getBookInPrice();
        List<Price> prices = book.getPrices();
        Date date = price.getDateFrom();
        Price prev = book.getPreviousPrice(date);
        prev.setDateTo(date);
        priceRepository.save(prev);
        for (Price price1 : prices) {
            if(price1.getDateFrom().compareTo(date) >= 0) {
                priceRepository.delete(price1);
            }
        }
        priceRepository.save(price);
    }

    public void addNewPromotion(Price price) {
        Book book = price.getBookInPrice();
        List<Price> prices = book.getPrices();
        prices.add(price);
        Date date1 = price.getDateFrom();
        Date date2 = price.getDateTo();

        prices.sort(Comparator.comparing(Price::getDateFrom));

        int index = prices.indexOf(price);
        int maxIndex = prices.size()-1;

        Price prev = prices.get(index-1);
        prev.setDateTo(date1);
        priceRepository.save(prev);

        if(index == maxIndex) {
            Price newPrice = Price.builder()
                    .dateFrom(date2)
                    .value(prev.getValue())
                    .bookInPrice(book)
                    .atDiscount(false)
                    .build();
            priceRepository.save(newPrice);
        }
        else {
            int index2 = index + 1;
            while (index2 < maxIndex && prices.get(index2).getDateTo().compareTo(date2) <= 0) {
                Price removedPrice = prices.get(index2);
                priceRepository.delete(removedPrice);
                prices.remove(index2);
                maxIndex--;
            }
            if(prices.get(index2).getDateFrom().compareTo(date2) > 0) {
                Price newPrice = Price.builder()
                        .dateFrom(date2)
                        .dateTo(prices.get(index2).getDateFrom())
                        .value(prev.getValue())
                        .bookInPrice(book)
                        .atDiscount(false)
                        .build();
                priceRepository.save(newPrice);
            }
            else {
                if(prices.get(index2).getDateFrom().compareTo(date2) < 0) {
                    prices.get(index2).setDateFrom(date2);
                    priceRepository.save(prices.get(index2));
                }
            }
        }
        priceRepository.save(price);
    }

    public void newPrice(PriceFormClass priceFormClass) {
        Book book = getBookById(priceFormClass.getBookId());
        int year = Integer.parseInt(priceFormClass.getDateFrom().substring(0,4));
        int month = Integer.parseInt(priceFormClass.getDateFrom().substring(5,7))-1;
        int day = Integer.parseInt(priceFormClass.getDateFrom().substring(8));
        Price price = Price.builder()
                .dateFrom(new GregorianCalendar(year, month, day).getTime())
                .value(priceFormClass.getValue())
                .bookInPrice(book)
                .atDiscount(false)
                .build();
        addNewPrice(price);
    }

    public void newProm(PriceFormClass priceFormClass) {
        Book book = getBookById(priceFormClass.getBookId());
        int year = Integer.parseInt(priceFormClass.getDateFrom().substring(0,4));
        int month = Integer.parseInt(priceFormClass.getDateFrom().substring(5,7))-1;
        int day = Integer.parseInt(priceFormClass.getDateFrom().substring(8));
        int year2 = Integer.parseInt(priceFormClass.getDateTo().substring(0,4));
        int month2 = Integer.parseInt(priceFormClass.getDateTo().substring(5,7))-1;
        int day2 = Integer.parseInt(priceFormClass.getDateTo().substring(8));
        Price price = Price.builder()
                .dateFrom(new GregorianCalendar(year, month, day).getTime())
                .dateTo(new GregorianCalendar(year2, month2, day2).getTime())
                .value(priceFormClass.getValue())
                .bookInPrice(book)
                .atDiscount(true)
                .build();
        addNewPromotion(price);
    }
}
