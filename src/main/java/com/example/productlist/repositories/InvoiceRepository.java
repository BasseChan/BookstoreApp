package com.example.productlist.repositories;

import com.example.productlist.domain.Book;
import com.example.productlist.domain.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
}
