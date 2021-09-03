package com.bustour.tikestapi.controller;

import com.bustour.tikestapi.dto.ticketDTO.AddTicketDTO;
import com.bustour.tikestapi.dto.ticketDTO.EditTicketDTO;
import com.bustour.tikestapi.models.Ticket;
import com.bustour.tikestapi.services.ITicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController {
    @Autowired
    private ITicketsService ticketsService;

    @GetMapping("/ticket")
    public List<Ticket> getAll(){
        return ticketsService.getAll();
    }

    @GetMapping("/ticket/available/{date}")
    public List<Ticket> getAllAvailable(@PathVariable(name = "date")String date){
        return ticketsService.getAllAvailable(date);
    }

    @GetMapping("/ticket/{id}")
    public Ticket get(@PathVariable(name = "id") Integer id){
        return ticketsService.get(id);
    }

    @PostMapping("/ticket")
    public Ticket add(@RequestBody AddTicketDTO ticketDTO){
        return ticketsService.post(ticketDTO);
    }

    @PutMapping("/ticket")
    public Ticket edit(@RequestBody EditTicketDTO ticketDTO){
        return ticketsService.put(ticketDTO);
    }

    @DeleteMapping("/ticket/{id}")
    public boolean delete(@PathVariable(name = "id")Integer id){
        return ticketsService.delete(id);
    }
}
