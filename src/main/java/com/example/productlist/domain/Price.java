package com.example.productlist.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "prices")
public class Price extends BaseEntity{

    @Builder
    public Price(Long id, Date dateFrom, Date dateTo, Float value, Boolean atDiscount, Book bookInPrice) {
        super(id);
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.value = value;
        this.atDiscount = atDiscount;
        this.bookInPrice = bookInPrice;
    }

    @Column(name = "dateFrom", nullable = false)
    private Date dateFrom;

    @Column(name = "dateTo")
    private Date dateTo;

    @Column(name = "value", nullable = false)
    private Float value;

    @Column(name = "atDiscount", nullable = false)
    private Boolean atDiscount;

    @ManyToOne()
    @JoinColumn(name = "bookInPrice")
    private Book bookInPrice;

    public String getStartDate_ddmmyyy() {
        String date = getStartDateString();
        return date.substring(8,10) + "." + date.substring(5,7) + "." + date.substring(0,4);
    }

    public String getEndDate_ddmmyyy() {
        if(dateTo == null) return "";
        String date = getEndDateString();
        return date.substring(8,10) + "." + date.substring(5,7) + "." + date.substring(0,4);
    }
    public String getTimePeriod() {
        return getStartDate_ddmmyyy() + " - " + getEndDate_ddmmyyy();
    }

    public String getValueString() {
        NumberFormat formatter = new DecimalFormat("0.00");
        return formatter.format(value) + "zł";
    }

    public String getStartDateString() {
        return dateFrom.toString().substring(0,10);
    }

    public String getEndDateString() {
        if(dateTo == null) return "";
        return dateTo.toString().substring(0,10);
    }
}
