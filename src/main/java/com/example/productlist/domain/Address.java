package com.example.productlist.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "addresses")
public class Address extends BaseEntity  {

    @Builder
    public Address(Long id, String country, String city, String zipCode, String street, String buildingNumber, String placeNumber) {
        super(id);
        this.country = country;
        this.city = city;
        this.zipCode = zipCode;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.placeNumber = placeNumber;
    }

    @Column(name = "country", nullable = false, length = 30)
    private String country;

    @Column(name = "city", nullable = false, length = 30)
    private String city;

    @Column(name = "zipCode", nullable = false, length = 6)
    private String zipCode;

    @Column(name = "street", nullable = false, length = 30)
    private String street;

    @Column(name = "buildingNumber", nullable = false, length = 10)
    private String buildingNumber;

    @Column(name = "placeNumber", length = 10)
    private String placeNumber;

    @OneToMany(
            mappedBy = "address", cascade = CascadeType.REMOVE
    )
    private List<Order> orders;
}
