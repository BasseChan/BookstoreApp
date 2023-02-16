package com.example.productlist.repositories;

import com.example.productlist.domain.Book;
import com.example.productlist.domain.Complaint;
import com.example.productlist.domain.ComplaintState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ComplaintRepository extends JpaRepository<Complaint,Long> {

    @Modifying
    @Query("update Complaint c set c.complaintState = :state where c.id = :id")
    void updateState(@Param(value = "id") long id, @Param(value = "state") ComplaintState state);
}
