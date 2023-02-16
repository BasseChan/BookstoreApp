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
@Table(name = "positions")
public class Position extends BaseEntity   {

    @Builder
    public Position(Long id) {
        super(id);
    }

    @Column(name = "quantity", nullable = false)
    private Integer quantity;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "orderInPosition", nullable = false)
    private Order orderInPosition;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bookInPosition", nullable = false)
    private Book bookInPosition;

}
