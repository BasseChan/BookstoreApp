package com.example.productlist.repositories;

import com.example.productlist.domain.Address;
import com.example.productlist.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
