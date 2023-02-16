package com.example.productlist.repositories;

import com.example.productlist.domain.Book;
import com.example.productlist.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order,Long> {
}
