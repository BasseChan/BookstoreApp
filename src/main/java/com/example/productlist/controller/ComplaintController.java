package com.example.productlist.controller;

import com.example.productlist.domain.Complaint;
import com.example.productlist.domain.Order;
import com.example.productlist.services.ComplaintService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ComplaintController {
    private final ComplaintService service;

    public ComplaintController(ComplaintService service) {
        this.service = service;
    }

    @GetMapping("/complaints/")
    public String complaintList(Model model) {
        model.addAttribute("complaintList", service.getAllComplaints());
        model.addAttribute("compliantStatesList", service.getAllComplaintStates());
        return "complaints/VComplaintsList";
    }

    @GetMapping("/complaint")
    public String complaintView(@RequestParam("id") long inputId, Model model) {
        Complaint complaint = service.getComplaintById(inputId);
        model.addAttribute("complaint", complaint);
        Order order = service.getOrderByComplaint(complaint);
        model.addAttribute("orderOnComplaint", order);
        model.addAttribute("positionsOfOrder", service.getPositions(order));
        return "complaints/VComplaint";
    }

    @PostMapping(value = {"/complaintAccepted"})
    public String accept(@RequestParam("id") long inputId, Model model) {
        service.updateStateOfComplaintById(service.getComplaintStateByName("Zatwierdzone"), inputId);
        service.setDateOfComplaintHandlingById(inputId);
        return "redirect:/complaint?id=" + inputId;
    }

    @PostMapping(value = {"/complaintDeclined"})
    public String decline(@RequestParam("id") long inputId, Model model) {
        service.updateStateOfComplaintById(service.getComplaintStateByName("Odrzucone"), inputId);
        service.setDateOfComplaintHandlingById(inputId);
        return "redirect:/complaint?id=" + inputId;
    }
}
