package com.example.productlist.repositories;

import com.example.productlist.domain.Address;
import com.example.productlist.domain.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price,Long> {
}
