package com.example.productlist.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "invoices")
public class Invoice extends BaseEntity
{
    @Builder
    public Invoice(Long id, String nip, String invoiceNumber, Float invoiceValue) {
        super(id);
        this.nip = nip;
        this.invoiceNumber = invoiceNumber;
        this.invoiceValue = invoiceValue;
    }

    @Column(name = "nip", nullable = false, length = 10)
    private String nip;

    @Column(name = "invoiceNumber", nullable = false, length = 15)
    private String invoiceNumber;

    @Column(name = "invoiceValue", nullable = false)
    private Float invoiceValue;
}
