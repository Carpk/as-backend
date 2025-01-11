package com.thekleinbottle.as_backend.web;

import org.springframework.web.bind.annotation.RestController;

import com.thekleinbottle.as_backend.domain.HelpTicket;
import com.thekleinbottle.as_backend.domain.HelpTicketRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HelpTicketController {
    private HelpTicketRepository repository;

    public HelpTicketController(HelpTicketRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/help-ticket")
    public String getCreateTicket() {
        return new String("Help is coming!");
    }

    
    @GetMapping("/help-tickets")
    public Iterable<HelpTicket> getAllTickets() {
        return repository.findAll();
    }
    

}
