package com.bustour.tikestapi.repo;

import com.bustour.tikestapi.models.Buyer;
import org.springframework.data.repository.CrudRepository;

public interface BuyersRepo extends CrudRepository<Buyer, Integer> {
}
