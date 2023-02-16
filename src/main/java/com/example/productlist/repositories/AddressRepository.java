package com.example.productlist.repositories;

import com.example.productlist.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


public interface AddressRepository extends JpaRepository<Address,Long> {
}
