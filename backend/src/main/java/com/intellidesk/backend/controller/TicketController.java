package com.intellidesk.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;

import com.intellidesk.backend.dto.CreateTicketRequest;
import com.intellidesk.backend.entity.Ticket;
import com.intellidesk.backend.service.TicketService;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    private final TicketService ticketService;
    
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    @PostMapping("/api/tickets")
    public Ticket createTicket(@RequestBody CreateTicketRequest request){
        return ticketService.createTicket(request);
    }

    @GetMapping("/api/tickets")
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/api/tickets/{id}")
    public Ticket getTicketById(@PathVariable Long id) {
    return ticketService.getTicketById(id);
    }

    @PutMapping("/api/tickets/{id}")
    public Ticket updateTicket(
        @PathVariable Long id,
        @RequestBody CreateTicketRequest request) {
    return ticketService.updateTicket(id, request);
    }

    @DeleteMapping("/api/tickets/{id}")
    public String deleteTicket(@PathVariable Long id) {
    ticketService.deleteTicket(id);
    return "Ticket deleted successfully";
    }

}