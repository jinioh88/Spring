package com.example.test1.service;

import com.example.test1.domain.Goods;
import com.example.test1.domain.Option;
import com.example.test1.persistence.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodService {
    @Autowired
    GoodsRepository repository;

    public List<Option> getOption(Long id) {
        List<Option> list = new ArrayList<>();
        list = repository.findOptionByGid(id);
        return list;
    }

    public Goods getGoods(Long id) {
        Goods goods = repository.findGoodsByGid(id);
        return goods;
    }

    public ArrayList<Goods> getAllGoods() {
        ArrayList<Goods> list = (ArrayList<Goods>) repository.findAll();
        return list;
    }
}
