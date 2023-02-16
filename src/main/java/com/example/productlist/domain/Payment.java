package com.example.productlist.domain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "payments")
public class Payment extends BaseEntity {

    @Builder
    public Payment(Long id, String paymentType,  Float  paymentValue,  Date dateOfPayment) {
        super(id);
        this.paymentType = paymentType;
        this.paymentValue = paymentValue;
        this.dateOfPayment = dateOfPayment;
    }

    @Column(name = "paymentType", nullable = false, length = 25)
    private String paymentType;

    @Column(name = "paymentValue", nullable = false)
    private Float paymentValue;

    @Column(name = "dateOfPayment", nullable = false)
    private Date dateOfPayment;



}
