package com.intellidesk.backend.service;

import org.springframework.stereotype.Service;

import com.intellidesk.backend.dto.CreateTicketRequest;

@Service
public class TicketService {

    public String createTicket(CreateTicketRequest request){
        String title = request.getTitle();
        String description = request.getDescription();
        String priority = request.getPriority();

        System.out.println("Processing Ticket");
        System.out.println("Title: "+title);
        System.out.println("Description: "+description);
        System.out.println("Priority: "+priority);

        return "Ticket processed successfully";
    }
    
}
