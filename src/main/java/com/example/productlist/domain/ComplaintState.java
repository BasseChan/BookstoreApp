package com.example.productlist.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "complaintStates")
public class ComplaintState extends BaseEntity {

    @Builder
    public ComplaintState(Long id, String stateName) {
        super(id);
        this.stateName = stateName;
    }

    @Column(name = "complaintName", nullable = false, length = 15)
    private String stateName;

    @OneToMany(
            mappedBy = "complaintState"
    )
    private List<Complaint> complaints;
}