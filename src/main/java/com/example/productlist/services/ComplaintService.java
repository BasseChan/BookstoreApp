package com.example.productlist.services;

import com.example.productlist.domain.Complaint;
import com.example.productlist.domain.ComplaintState;
import com.example.productlist.domain.Order;
import com.example.productlist.domain.Position;
import com.example.productlist.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@org.springframework.stereotype.Service
public class ComplaintService {
    @Autowired
    ComplaintRepository complaintRepository;
    @Autowired
    ComplaintStateRepository complaintStateRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    PositionRepository positionRepository;

    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    public List<ComplaintState> getAllComplaintStates() {
        return complaintStateRepository.findAll();
    }

    public Complaint getComplaintById(long id) {
        var value= complaintRepository.findById(id);
        return value.isEmpty()?null:value.get();
    }

    public void updateStateOfComplaintById(ComplaintState state, long id) {
        Complaint complaint = getComplaintById(id);
        complaint.setComplaintState(state);
        complaintRepository.save(complaint);
    }

    public Order getOrderByComplaint(Complaint complaint) {
        List<Order> orders = orderRepository.findAll();
        for (Order order : orders) {
            if (order.getComplaint() == complaint) {
                return order;
            }
        }
        return new Order();
    }

    public List<Position> getPositions(Order order) {
        List<Position> list = new ArrayList<>();
        List<Position> positions = positionRepository.findAll();
        for (Position position : positions) {
            if (position.getOrderInPosition() == order) {
                list.add(position);
            }
        }
        return list;
    }

    public ComplaintState getComplaintStateByName(String name) {
        List<ComplaintState> complaintStates = complaintStateRepository.findAll();
        for (ComplaintState complaintState : complaintStates) {
            if (Objects.equals(complaintState.getStateName(), name)) {
                return complaintState;
            }
        }
        return complaintStates.get(0);
    }

    public void setDateOfComplaintHandlingById(long id) {
        Complaint complaint = getComplaintById(id);
        complaint.setDateOfComplaintHandling(new Date());
        complaintRepository.save(complaint);
    }
}
