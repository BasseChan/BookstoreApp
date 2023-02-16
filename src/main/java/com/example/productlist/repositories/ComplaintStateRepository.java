package com.example.productlist.repositories;

import com.example.productlist.domain.Book;
import com.example.productlist.domain.ComplaintState;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ComplaintStateRepository extends JpaRepository<ComplaintState,Long> {
}
