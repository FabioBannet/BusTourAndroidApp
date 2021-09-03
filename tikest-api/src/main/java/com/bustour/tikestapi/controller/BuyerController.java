package com.bustour.tikestapi.controller;

import com.bustour.tikestapi.dto.buyerDTO.AddBuyerDTO;
import com.bustour.tikestapi.dto.buyerDTO.EditBuyerDTO;
import com.bustour.tikestapi.models.Buyer;
import com.bustour.tikestapi.services.IBuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BuyerController {
    @Autowired
    private IBuyerService buyerService;

    @GetMapping("/buyer")
    public List<Buyer> getAll(){
        return buyerService.getAll();
    }

    @GetMapping("/buyer/{id}")
    public Buyer get(@PathVariable(name = "id") Integer id){
        return buyerService.get(id);
    }

    @PostMapping("/buyer")
    public Buyer add(@RequestBody AddBuyerDTO buyerDTO){
        return buyerService.post(buyerDTO);
    }

    @PutMapping("/buyer")
    public Buyer edit(@RequestBody EditBuyerDTO buyerDTO){
        return buyerService.put(buyerDTO);
    }

    @DeleteMapping("/buyer/{id}")
    public boolean delete(@PathVariable(name = "id")Integer id){
        return buyerService.delete(id);
    }
}
