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
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "orders")
public class Order  extends BaseEntity  {

    @Builder
    public Order(Long id, Double orderValue, Date dateOfOrderPlacement, Date dateOfOrderSending, Date dateOfOrderDelivery, String deliveryType, List<Position> positions, Payment payment, Invoice invoice, Address address, Client client, OrderState orderState, Complaint complaint) {
        super(id);
        this.orderValue = orderValue;
        this.dateOfOrderPlacement = dateOfOrderPlacement;
        this.dateOfOrderSending = dateOfOrderSending;
        this.dateOfOrderDelivery = dateOfOrderDelivery;
        this.deliveryType = deliveryType;
        this.positions = positions;
        this.payment = payment;
        this.invoice = invoice;
        this.address = address;
        this.client = client;
        this.orderState = orderState;
        this.complaint = complaint;
    }

    @Column(name = "orderValue", nullable = false)
    private Double orderValue;
    @Column(name = "dateOfOrderPlacement", nullable = false)
    private Date dateOfOrderPlacement;
    @Column(name = "dateOfOrderSending")
    private Date dateOfOrderSending;

    @Column(name = "dateOfOrderDelivery")
    private Date dateOfOrderDelivery;

    @Column(name = "deliveryType", nullable = false, length = 30)
    private String deliveryType;


    @OneToMany(
            mappedBy = "orderInPosition", cascade = CascadeType.REMOVE
    )
    private List<Position> positions;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paymentInOrder")
    private Payment payment;

    @OneToOne()
    @JoinColumn(name = "invoiceInOrder")
    private Invoice invoice;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "addressInOrder")
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientInOrder")
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "orderStateInOrder", nullable = false)
    private OrderState orderState;

    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "complaintInOrder")
    private Complaint complaint;

    public String getDateOfOrderPlacementShort() {
        return dateOfOrderPlacement.toString().substring(0,10);
    }
    public String getDateOfOrderSendingShort() {
        return dateOfOrderSending.toString().substring(0,10);
    }
    public String getDateOfOrderDeliveryShort() {
        return dateOfOrderDelivery.toString().substring(0,10);
    }

    public String getValueString() {
        NumberFormat formatter = new DecimalFormat("0.00");
        return formatter.format(orderValue) + "zł";
    }

    public String getDateOfOrderPlacement_ddmmyyyy() {
        String sDate = getDateOfOrderPlacementShort();
        return sDate.substring(8,10) + "." + sDate.substring(5,7) + "." + sDate.substring(0,4);
    }
}
