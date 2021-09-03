package com.bustour.tikestapi.repo;

import com.bustour.tikestapi.models.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketsRepo extends CrudRepository<Ticket, Integer> {
    @Query(value = "SELECT * FROM public.ticket AS t WHERE t.date = ?1 AND t.buyer_id IS NULL ",
    nativeQuery = true)
    List<Ticket> findAllAvailableTickets(String date);
}
