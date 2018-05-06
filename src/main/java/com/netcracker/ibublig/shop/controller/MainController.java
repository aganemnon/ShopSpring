package com.netcracker.ibublig.shop.controller;

import com.netcracker.ibublig.shop.domain.Item;
import com.netcracker.ibublig.shop.repos.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private ItemRepo itemRepo;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/test")
    public String test(Map<String, Object> model) {
        Iterable<Item> items = itemRepo.findAll();

        model.put("items", items);

        return "test";
    }

    @PostMapping("/test")
    public String addItem(@RequestParam String name, @RequestParam String description, @RequestParam String cost, @RequestParam String count, Map<String, Object> model) {
        Item item = new Item(name, description, Integer.parseInt(cost), Integer.parseInt(count));

        itemRepo.save(item);

        Iterable<Item> items = itemRepo.findAll();

        model.put("items", items);

        return "test";
    }

    @PostMapping("filter")
    public String find(@RequestParam String name, Map<String, Object> model){
        Iterable<Item> items;

        if (name != null && !name.isEmpty()){
            items = itemRepo.findByName(name);
        } else {
            items = itemRepo.findAll();
        }
        model.put("items", items);
        return "test";
    }

}