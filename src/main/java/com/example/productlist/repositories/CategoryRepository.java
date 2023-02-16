package com.example.productlist.repositories;

import com.example.productlist.domain.Address;
import com.example.productlist.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
