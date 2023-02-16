package com.example.productlist.domain;


import com.example.productlist.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "complaints")

public class Complaint extends BaseEntity  {
    @Builder
    public Complaint(Long id, Date dateOfComplaintPlacement, Date dateOfComplaintHandling, String description, Integer worker, Client client, ComplaintState complaintState, Order order) {
        super(id);
        this.dateOfComplaintPlacement = dateOfComplaintPlacement;
        this.dateOfComplaintHandling = dateOfComplaintHandling;
        this.description = description;
        this.worker = worker;
        this.client = client;
        this.complaintState = complaintState;
    }

    @Column(name = "dateOfComplaintPlacement", nullable = false)
    private Date dateOfComplaintPlacement;

    @Column(name = "dateOfComplaintHandling")
    private Date dateOfComplaintHandling;

    @Column(name = "description", nullable = false, length = 200)
    private String description;

    @Column(name = "worker")
    private Integer worker;


    @ManyToOne(optional = false)
    @JoinColumn(name = "clientInComplaint", nullable = false)
    private Client client;

    @ManyToOne(optional = false)
    @JoinColumn(name = "complaintStateInComplaint", nullable = false)
    private ComplaintState complaintState;

    public String getDateOfComplaintPlacementShort() {
        return dateOfComplaintPlacement.toString().substring(0,10);
    }
    public String getDateOfComplaintHandlingShort() {
        if(dateOfComplaintHandling != null)
            return dateOfComplaintHandling.toString().substring(0,10);
        return "";
    }
    public String getDateOfComplaintPlacement_ddmmyyyy() {
        String sDate = getDateOfComplaintPlacementShort();
        return sDate.substring(8,10) + "." + sDate.substring(5,7) + "." + sDate.substring(0,4);
    }
    public String getDateOfComplaintHandling_ddmmyyyy() {
        if(dateOfComplaintHandling == null) return "";
        String sDate = getDateOfComplaintHandlingShort();
        return sDate.substring(8,10) + "." + sDate.substring(5,7) + "." + sDate.substring(0,4);
    }

}
