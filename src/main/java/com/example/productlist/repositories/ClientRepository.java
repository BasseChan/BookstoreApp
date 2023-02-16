package com.example.productlist.repositories;

import com.example.productlist.domain.Address;
import com.example.productlist.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client,Long> {
}
