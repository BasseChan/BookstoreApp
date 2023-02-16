package com.example.productlist.repositories;

import com.example.productlist.domain.Address;
import com.example.productlist.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book,Long> {
}
