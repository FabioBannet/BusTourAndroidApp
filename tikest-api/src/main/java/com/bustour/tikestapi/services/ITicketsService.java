package com.bustour.tikestapi.services;

import com.bustour.tikestapi.dto.ticketDTO.AddTicketDTO;
import com.bustour.tikestapi.dto.ticketDTO.EditTicketDTO;
import com.bustour.tikestapi.models.Ticket;

import java.util.List;

public interface ITicketsService {
    List<Ticket> getAll();
    List<Ticket> getAllAvailable(String data);
    Ticket get(Integer id);
    Ticket post(AddTicketDTO ticketDTO);
    Ticket put(EditTicketDTO ticketDTO);
    boolean delete(Integer id);
}
