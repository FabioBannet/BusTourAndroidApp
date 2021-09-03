package com.bustour.tikestapi.services;

import com.bustour.tikestapi.dto.ticketDTO.AddTicketDTO;
import com.bustour.tikestapi.dto.ticketDTO.EditTicketDTO;
import com.bustour.tikestapi.models.Buyer;
import com.bustour.tikestapi.models.Ticket;
import com.bustour.tikestapi.repo.BuyersRepo;
import com.bustour.tikestapi.repo.TicketsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TicketsService implements ITicketsService{
    @Autowired
    private TicketsRepo ticketsRepo;
    @Autowired
    private BuyersRepo buyersRepo;


    @Override
    public List<Ticket> getAll() {

        List<Ticket> tickets = new ArrayList<>();

        try{
            Iterable<Ticket> ticketsEntities = ticketsRepo.findAll();

            ticketsEntities.forEach(ticket -> tickets.add(ticket));
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }finally {
            return tickets;
        }
    }

    @Override
    public List<Ticket> getAllAvailable(String data) {
        List<Ticket> tickets = new ArrayList<>();

        try{
            Iterable<Ticket> ticketsEntities = ticketsRepo.findAllAvailableTickets(data);

            ticketsEntities.forEach(ticket -> tickets.add(ticket));
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }finally {
            return tickets;
        }
    }

    @Override
    public Ticket get(Integer id) {
        Ticket ticket = new Ticket();
        try{
           ticket = ticketsRepo.findById(id)
                           .get();
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }finally {
            return ticket;
        }
    }

    @Override
    public Ticket post(AddTicketDTO ticketDTO) {
        Ticket ticket = new Ticket();
        try{
            ticket.setDirection(ticketDTO.getDirection());
            ticket.setDate(ticketDTO.getData());
            ticket.setDeparture_time(ticketDTO.getDeparture_time());
            ticket.setArrival_time(ticketDTO.getArrival_time());
            ticket.setSeat(ticketDTO.getSeat());
            ticket.setPrice(ticketDTO.getPrice());

            if(ticketDTO.getBuyer_id() != null && ticketDTO.getBuyer_id() > 0 ){
                Buyer buyer = buyersRepo
                        .findById(ticketDTO.getBuyer_id())
                        .get();
                ticket.setBuyer(buyer);
            }


            ticket = ticketsRepo.save(ticket);

        }catch (NoSuchElementException e){
            e.printStackTrace();
        }finally {
            return ticket;
        }
    }

    @Override
    public Ticket put(EditTicketDTO ticketDTO) {
        Ticket ticket = new Ticket();
        try{
            ticket = ticketsRepo.findById(ticketDTO.getId())
                            .get();

            ticket.setDirection(ticketDTO.getDirection());
            ticket.setDate(ticketDTO.getDate());
            ticket.setDeparture_time(ticketDTO.getDeparture_time());
            ticket.setArrival_time(ticketDTO.getArrival_time());
            ticket.setSeat(ticketDTO.getSeat());
            ticket.setPrice(ticketDTO.getPrice());

            Buyer buyer = buyersRepo
                    .findById(ticketDTO.getBuyer_id())
                    .get();
            ticket.setBuyer(buyer);

            ticket = ticketsRepo.save(ticket);

        }catch (NoSuchElementException e){
            e.printStackTrace();
        }finally {
            return ticket;
        }
    }

    @Override
    public boolean delete(Integer id) {
        try{
            Ticket ticket =ticketsRepo
                    .findById(id)
                    .get();

            ticketsRepo.delete(ticket);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
