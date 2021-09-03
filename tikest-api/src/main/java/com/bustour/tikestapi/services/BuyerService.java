package com.bustour.tikestapi.services;

import com.bustour.tikestapi.dto.buyerDTO.AddBuyerDTO;
import com.bustour.tikestapi.dto.buyerDTO.EditBuyerDTO;
import com.bustour.tikestapi.models.Buyer;
import com.bustour.tikestapi.repo.BuyersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BuyerService implements IBuyerService{
    @Autowired
    private BuyersRepo buyersRepo;

    @Override
    public List<Buyer> getAll() {
        List<Buyer> buyers = new ArrayList<>();

        try{
            Iterable<Buyer> buyersEntities = buyersRepo.findAll();

            buyersEntities.forEach(buyer -> buyers.add(buyer));
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }finally {
            return buyers;
        }
    }

    @Override
    public Buyer get(Integer id) {
        Buyer buyer = new Buyer();
        try{
            buyer = buyersRepo.findById(id)
                    .get();
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }finally {
            return buyer;
        }
    }

    @Override
    public Buyer post(AddBuyerDTO buyerDTO) {
        Buyer buyer = new Buyer();
        try{
            buyer.setFio(buyerDTO.getFio());
            buyer.setMobile_number(buyerDTO.getMobile_number());

            buyer = buyersRepo.save(buyer);

        }catch (NoSuchElementException e){
            e.printStackTrace();
        }finally {
            return buyer;
        }
    }

    @Override
    public Buyer put(EditBuyerDTO buyerDTO) {
        Buyer buyer = new Buyer();
        try{
            buyer = buyersRepo.findById(buyerDTO.getId())
                    .get();
            buyer.setFio(buyerDTO.getFio());
            buyer.setMobile_number(buyerDTO.getMobile_number());

            buyer = buyersRepo.save(buyer);

        }catch (NoSuchElementException e){
            e.printStackTrace();
        }finally {
            return buyer;
        }
    }

    @Override
    public boolean delete(Integer id) {
        try{
            Buyer buyer = buyersRepo
                    .findById(id)
                    .get();

            buyersRepo.delete(buyer);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
