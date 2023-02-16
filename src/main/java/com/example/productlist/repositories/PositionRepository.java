package com.example.productlist.repositories;

import com.example.productlist.domain.Book;
import com.example.productlist.domain.Position;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PositionRepository extends JpaRepository<Position,Long> {
}
