package com.example.productlist.repositories;

import com.example.productlist.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
