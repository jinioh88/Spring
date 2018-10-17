package com.example.test1.controller;

import com.example.test1.domain.BasketProduct;
import com.example.test1.persistence.BasketRepository;
import com.example.test1.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/basket")
public class BasketController {
    @Autowired
    BasketService service;

    @GetMapping("/list")
    public String getBasketList(Model model) {
        List<BasketProduct> list = new ArrayList<>();
        list = service.getBasketList();

        model.addAttribute("list",list);
        return "basketList";
    }
}
