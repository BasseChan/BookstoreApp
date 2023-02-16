package com.example.productlist.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import java.util.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "books")
public class Book extends BaseEntity   {


    @Builder
    public Book(Long id, String title, Integer availability, Boolean inOffer, String description) {
        super(id);
        this.title = title;
        this.availability = availability;
        this.inOffer = inOffer;
        this.description = description;
    }

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "availability", nullable = false)
    private Integer availability;

    @Column(name = "inOffer", nullable = false)
    private Boolean inOffer = false;

    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @OneToMany(
            mappedBy = "bookInPosition"
    )
    private List<Position> positions;

    @OneToMany(
            mappedBy = "bookInCategory_Book"
    )
    private List<Category_Book> category_bookList;

    @OneToMany(
            mappedBy = "bookInAuthor_Book"
    )
    private List<Author_Book> author_bookList;

    @OneToMany(
            mappedBy = "bookInPrice"
    )
    private List<Price> prices;

    public String getCategoriesAsString() {
        StringBuilder s = new StringBuilder();
        for (Category_Book category_book : category_bookList) {
            s.append(category_book.getCategoryInCategory_Book().getCategoryName()).append("\n");
        }
        if(!s.toString().equals("")) {
            s = new StringBuilder(s.substring(0, s.length() - 1));
        }
        return s.toString();
    }

    public String getAuthorsAsString() {
        StringBuilder s = new StringBuilder();
        for (Author_Book author_book : getAuthor_bookList()) {
            s.append(author_book.getAuthorInAuthor_Book().getFullName()).append("\n");
        }
        if(!s.toString().equals("")) {
            s = new StringBuilder(s.substring(0, s.length() - 1));
        }
        return s.toString();
    }

    public Price getActualPrice() {
        return getPreviousPrice(new Date());
    }

    public Price getPreviousPrice(Date date) {
        for (Price value : prices) {
            if (value.getDateFrom().compareTo(date) <= 0) {
                if (value.getDateTo() == null || value.getDateTo().compareTo(date) >= 0) {
                    return value;
                }
            }
        }
        return prices.get(0);
    }

    public List<Price> getPricesSorted() {
        List<Price> prices = getPrices();
        prices.sort(Comparator.comparing(Price::getDateFrom));
        return prices;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
    }

    public Boolean getInOffer() {
        return inOffer;
    }

    public void setInOffer(Boolean inOffer) {
        this.inOffer = inOffer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public List<Category_Book> getCategory_bookList() {
        return category_bookList;
    }

    public void setCategory_bookList(List<Category_Book> category_bookList) {
        this.category_bookList = category_bookList;
    }

    public List<Author_Book> getAuthor_bookList() {
        return author_bookList;
    }

    public void setAuthor_bookList(List<Author_Book> author_bookList) {
        this.author_bookList = author_bookList;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

}
