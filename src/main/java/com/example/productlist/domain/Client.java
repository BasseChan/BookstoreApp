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
@Table(name = "clients")
public class Client extends BaseEntity{
    @Builder
    public Client(Long id, String name, String surname, String email, String telephoneNumber, Integer loyalPoints, Integer account, Address address) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.loyalPoints = loyalPoints;
        this.account = account;
        this.address = address;
    }

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "surname", nullable = false, length = 30)
    private String surname;

    @Column(name = "email", nullable = false, length = 30)
    private String email;

    @Column(name = "telephoneNumber", nullable = false, length = 15)
    private String telephoneNumber;

    @Column(name = "loyalPoints", nullable = false)
    private Integer loyalPoints;

    @Column(name = "account")
    private Integer account;

    @OneToOne()
    @JoinColumn(name = "addressInClient")
    private Address address;

    @OneToMany(
            mappedBy = "client"
    )
    private List<Order> orders;

    @OneToMany(
            mappedBy = "client"
    )
    private List<Complaint> complaint;

    public String getFullName() {
        return name + ' ' + surname;
    }
}
