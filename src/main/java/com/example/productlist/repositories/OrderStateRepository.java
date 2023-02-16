package com.example.productlist.repositories;

import com.example.productlist.domain.Book;
import com.example.productlist.domain.OrderState;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderStateRepository extends JpaRepository<OrderState,Long> {
}
