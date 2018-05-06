package com.netcracker.ibublig.shop.repos;

import com.netcracker.ibublig.shop.domain.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepo extends CrudRepository<Item, Long> {
    List<Item> findByName(String name);
}
