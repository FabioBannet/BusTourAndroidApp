package com.bustour.tikestapi.services;

import com.bustour.tikestapi.dto.buyerDTO.AddBuyerDTO;
import com.bustour.tikestapi.dto.buyerDTO.EditBuyerDTO;
import com.bustour.tikestapi.models.Buyer;

import java.util.List;

public interface IBuyerService {
    List<Buyer> getAll();
    Buyer get(Integer id);
    Buyer post(AddBuyerDTO ticketDTO);
    Buyer put(EditBuyerDTO ticketDTO);
    boolean delete(Integer id);
}
