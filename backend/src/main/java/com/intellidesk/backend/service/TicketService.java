
package com.intellidesk.backend.service;

import java.util.List;

import com.intellidesk.backend.dto.CreateTicketRequest;
import com.intellidesk.backend.entity.Ticket;
import com.intellidesk.backend.repository.TicketRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    // Constructor injection
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket createTicket(CreateTicketRequest request) {

        // Convert incoming DTO into Entity
        Ticket ticket = new Ticket();

        ticket.setTitle(request.getTitle());
        ticket.setDescription(request.getDescription());
        ticket.setPriority(request.getPriority());

        // Save entity into PostgreSQL
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(Long id) {
    return ticketRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Ticket not found with id: " + id));
    }

    public Ticket updateTicket(Long id, CreateTicketRequest request) {
    Ticket ticket = ticketRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Ticket not found"));

    ticket.setTitle(request.getTitle());
    ticket.setDescription(request.getDescription());
    ticket.setPriority(request.getPriority());
    return ticketRepository.save(ticket);
    }

    public void deleteTicket(Long id) {
    if (!ticketRepository.existsById(id)) {
        throw new RuntimeException("Ticket not found");
    }

    ticketRepository.deleteById(id);
    }


}
