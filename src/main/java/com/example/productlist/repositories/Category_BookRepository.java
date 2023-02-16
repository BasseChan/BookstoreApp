package com.example.productlist.repositories;

import com.example.productlist.domain.Address;
import com.example.productlist.domain.Category_Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Category_BookRepository extends JpaRepository<Category_Book,Long> {
}
