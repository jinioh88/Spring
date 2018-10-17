package com.example.test1.controller.api;

import com.example.test1.domain.BasketProduct;
import com.example.test1.domain.Goods;
import com.example.test1.domain.Option;
import com.example.test1.persistence.BasketRepository;
import com.example.test1.persistence.GoodsRepository;
import com.example.test1.persistence.OptionRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;

import static java.time.LocalDateTime.now;

@RestController
@RequestMapping("/api/basket/")
@Log
public class BasketApiController {
    @Autowired
    private BasketRepository repository;
    @Autowired
    private GoodsRepository goodsRepository;
    @Autowired
    private OptionRepository optionRepository;

    @Transactional
    @PostMapping
    public String addBaskets(@RequestBody BasketProduct basketProduct) {
        repository.save(basketProduct);
        return "ok";
    }

    @Transactional
    @PostMapping("/{gid}/{oid}")
    public String addBasket(@PathVariable("gid") Long gid, @PathVariable("oid") Long oid,
                                                                            @RequestBody BasketProduct basketProduct) {
        log.info("addBasket!!");
        log.info("GID : "+gid);
        log.info("OID : "+oid);
        System.out.println("=======================");
        System.out.println(basketProduct.getQuantity());
        System.out.println("=======================");

        Goods goods = goodsRepository.findGoodsByGid(gid);

        basketProduct.setGoods(goods);
        basketProduct.setRegTime(now());
        Option option = new Option();
        option = optionRepository.findOptionByOid(oid);
        basketProduct.setOption(option);
        repository.save(basketProduct);

//        return new ResponseEntity<>(getBasketList(),HttpStatus.CREATED);
        return "ok";
    }

    private List<BasketProduct> getBasketList() throws RuntimeException {
        log.info("getBasketList");
        return repository.findAll();
    }
}
