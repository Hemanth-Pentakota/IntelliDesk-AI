package com.intellidesk.backend.controller;

import com.intellidesk.backend.dto.CreateTicketRequest;
import com.intellidesk.backend.service.TicketService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    private final TicketService ticketService;
    
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    @PostMapping("/api/tickets")
    public String createTicket(@RequestBody CreateTicketRequest request){

        System.out.println("Title: " + request.getTitle());
        System.out.println("Description: " + request.getDescription());
        System.out.println("Priority: " + request.getPriority());
        return ticketService.createTicket(request);
    }

}