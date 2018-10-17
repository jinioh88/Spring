package com.example.test1.service;

import com.example.test1.domain.BasketProduct;
import com.example.test1.persistence.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasketService {
    @Autowired
    BasketRepository repository;

    public List<BasketProduct> getBasketList() {
        List<BasketProduct> list = new ArrayList<>();
        list = repository.findAll();
        return list;
    }
}
