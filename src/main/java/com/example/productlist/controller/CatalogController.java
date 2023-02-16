package com.example.productlist.controller;

import com.example.productlist.domain.*;
import com.example.productlist.model.AvailabilityFormClass;
import com.example.productlist.model.BookFormClass;
import com.example.productlist.services.CatalogService;
import com.example.productlist.model.PriceFormClass;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CatalogController {

    private final CatalogService service;

    public CatalogController(CatalogService service) {
        this.service = service;
    }

    @GetMapping("/catalog/")
    public String catalog(Model model) {
        model.addAttribute("books", service.getAllOfferedBooks());
        model.addAttribute("availability", new AvailabilityFormClass(0, 0));
        model.addAttribute("operation", 0);
        return "catalog/VCatalog";
    }

    @GetMapping("/catalog/book")
    public String book(@RequestParam("id") long inputId, Model model) {
        Book book = service.getBookById(inputId);
        model.addAttribute("book", book);
        model.addAttribute("normPrice", new PriceFormClass(inputId));
        model.addAttribute("promPrice", new PriceFormClass(inputId));
        model.addAttribute("operation", 0);
        return "catalog/VBook";
    }

    @GetMapping("/catalog/book_modified")
    public String bookModified(@RequestParam("id") long inputId, Model model) {
        Book book = service.getBookById(inputId);
        model.addAttribute("book", book);
        model.addAttribute("normPrice", new PriceFormClass(inputId));
        model.addAttribute("promPrice", new PriceFormClass(inputId));
        model.addAttribute("operation", 1);
        return "catalog/VBook";
    }

    @GetMapping("/catalog/book_not_modified")
    public String bookNotModified(@RequestParam("id") long inputId, Model model) {
        Book book = service.getBookById(inputId);
        model.addAttribute("book", book);
        model.addAttribute("normPrice", new PriceFormClass(inputId));
        model.addAttribute("promPrice", new PriceFormClass(inputId));
        model.addAttribute("operation", 2);
        return "catalog/VBook";
    }

    @GetMapping("/catalog/price_added")
    public String priceAdded(@RequestParam("id") long inputId, Model model) {
        Book book = service.getBookById(inputId);
        model.addAttribute("book", book);
        model.addAttribute("normPrice", new PriceFormClass(inputId));
        model.addAttribute("promPrice", new PriceFormClass(inputId));
        model.addAttribute("operation", 3);
        return "catalog/VBook";
    }

    @GetMapping("/catalog/promotion_added")
    public String promotionAdded(@RequestParam("id") long inputId, Model model) {
        Book book = service.getBookById(inputId);
        model.addAttribute("book", book);
        model.addAttribute("normPrice", new PriceFormClass(inputId));
        model.addAttribute("promPrice", new PriceFormClass(inputId));
        model.addAttribute("operation", 4);
        return "catalog/VBook";
    }

    @GetMapping("/catalog/book_availability_changed")
    public String availabilityChanged(@RequestParam("id") long inputId, Model model) {
        Book book = service.getBookById(inputId);
        model.addAttribute("book", book);
        model.addAttribute("normPrice", new PriceFormClass(inputId));
        model.addAttribute("promPrice", new PriceFormClass(inputId));
        model.addAttribute("operation", 5);
        return "catalog/VBook";
    }

    @GetMapping("/catalog/newbook")
    public String newBook(Model model) {
        Book book = Book.builder().build();
        BookFormClass formHelper = new BookFormClass(book);
        model.addAttribute("newBook", formHelper );
        return "catalog/VNewBook";
    }

    @PostMapping("/catalog/newbook")
    public String addNewBook(@ModelAttribute BookFormClass bookFormClass) {
        Book newBook = bookFormClass.getBook();
        newBook.setInOffer(true);
        service.addNewBook(newBook);
        service.categoriesToDatabase(bookFormClass);
        service.authorsToDatabase(bookFormClass);
        service.priceForNewBook(bookFormClass);
        return "redirect:/catalog/new_book_added";
    }

    @GetMapping("/catalog/remove")
    public String remove(@RequestParam("id") long id) {
        service.deleteBookById(id);
        return "redirect:/catalog/remove_done";
    }

    @GetMapping("/catalog/remove_done")
    public String removeDone(Model model) {
        model.addAttribute("books", service.getAllOfferedBooks());
        model.addAttribute("availability", new AvailabilityFormClass(0, 0));
        model.addAttribute("operation", 1);
        return "catalog/VCatalog";
    }

    @GetMapping("/catalog/new_book_added")
    public String newBookDone(Model model) {
        model.addAttribute("books", service.getAllOfferedBooks());
        model.addAttribute("availability", new AvailabilityFormClass(0, 0));
        model.addAttribute("operation", 3);
        return "catalog/VCatalog";
    }

    @GetMapping("/catalog/new_book_not_added")
    public String newBookNotDone(Model model) {
        model.addAttribute("books", service.getAllOfferedBooks());
        model.addAttribute("availability", new AvailabilityFormClass(0, 0));
        model.addAttribute("operation", 4);
        return "catalog/VCatalog";
    }

    @GetMapping("/catalog/availability_changed")
    public String availabilityChanged(Model model) {
        model.addAttribute("books", service.getAllOfferedBooks());
        model.addAttribute("availability", new AvailabilityFormClass(0, 0));
        model.addAttribute("operation", 5);
        return "catalog/VCatalog";
    }

    @PostMapping("/catalog/bookAvailability")
    public String changeAvailabilityFromBook(@ModelAttribute Book book) {
        service.updateBook(book);
        return "redirect:/catalog/book_availability_changed?id=" + book.getId();
    }

    @PostMapping("/catalog/catalogAvailability")
    public String changeAvailabilityFromCatalog(@ModelAttribute AvailabilityFormClass availabilityFormClass) {
        Book book = service.getBookById(availabilityFormClass.getId());
        book.setAvailability(availabilityFormClass.getAvailability());
        service.updateBook(book);
        return "redirect:/catalog/availability_changed";
    }

    @GetMapping("/catalog/modifyBook")
    public String modifyBook(@RequestParam("id") long inputId, Model model) {
        Book book = service.getBookById(inputId);
        BookFormClass formHelper = new BookFormClass(book);
        String categories = book.getCategoriesAsString();
        String authors = book.getAuthorsAsString();
        formHelper.setCategories(categories);
        formHelper.setCategoriesPrev(categories);
        formHelper.setAuthors(authors);
        formHelper.setAuthorsPrev(authors);
        model.addAttribute("changedBook", formHelper );
        return "catalog/VModifyBook";
    }

    @PostMapping("/catalog/modifyBook")
    public String modifyBook(@ModelAttribute BookFormClass bookFormClass) {
        Book book = bookFormClass.getBook();
        service.updateBook(book);
        service.updateCategories(bookFormClass);
        service.updateAuthors(bookFormClass);
        return "redirect:/catalog/book_modified?id=" + book.getId();
    }

    @PostMapping("/catalog/newPrice")
    public String newPrice(@ModelAttribute PriceFormClass price) {
        service.newPrice(price);
        return "redirect:/catalog/price_added?id=" + price.getBookId();
    }

    @PostMapping("/catalog/newPromotion")
    public String newProm(@ModelAttribute PriceFormClass price) {
        service.newProm(price);
        return "redirect:/catalog/promotion_added?id=" + price.getBookId();
    }
}
