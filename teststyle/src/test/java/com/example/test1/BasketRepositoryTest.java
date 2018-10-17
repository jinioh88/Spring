package com.example.test1;

import com.example.test1.domain.BasketProduct;
import com.example.test1.domain.Goods;
import com.example.test1.persistence.BasketRepository;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class BasketRepositoryTest {
    @Autowired
    BasketRepository repository;

    @Test
    public void testInsertRBasket() {
        Long[] arr = {1L, 2L, 3L};
        Arrays.stream(arr).forEach(num -> {
            Goods goods = new Goods();
            goods.setGid(num);

            BasketProduct basketProduct = new BasketProduct();
            basketProduct.setBid(1L);
            basketProduct.setQuantity(10);
            basketProduct.setRegTime(LocalDateTime.now());
            basketProduct.setGoods(goods);

            repository.save(basketProduct);
        });
    }
}
