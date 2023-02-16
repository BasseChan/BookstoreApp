package com.example.productlist.model;

import com.example.productlist.domain.Price;

public class PriceFormClass {
    private String dateFrom;
    private String dateTo;
    private long bookId;
    private float value;

    public PriceFormClass(String dateFrom, String dateTo, long bookId, float value) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.bookId = bookId;
        this.value = value;
    }

    public PriceFormClass(long bookId) {
        this.bookId = bookId;
    }

    public PriceFormClass() {
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
