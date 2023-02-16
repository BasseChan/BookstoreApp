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
@Table(name = "orderStates")
public class OrderState extends BaseEntity {

    @Builder
    public OrderState(Long id, String stateName) {
        super(id);
        this.stateName = stateName;
    }

    @Column(name = "stateName", nullable = false, length = 15)
    private String stateName;

}