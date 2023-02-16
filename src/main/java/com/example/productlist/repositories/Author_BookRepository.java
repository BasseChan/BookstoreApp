package com.example.productlist.repositories;

import com.example.productlist.domain.Address;
import com.example.productlist.domain.Author_Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Author_BookRepository extends JpaRepository<Author_Book,Long> {
}
