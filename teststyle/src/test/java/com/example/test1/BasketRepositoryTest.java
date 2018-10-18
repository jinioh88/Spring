package com.example.test1;

import com.example.test1.domain.BasketProduct;
import com.example.test1.domain.Goods;
import com.example.test1.persistence.BasketRepository;
import com.example.test1.persistence.GoodsRepository;
import com.example.test1.persistence.OptionRepository;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class BasketRepositoryTest {
    @Autowired
    BasketRepository basketRepository;
    @Autowired
    GoodsRepository goodsRepository;
    @Autowired
    OptionRepository optionRepository;

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

            basketRepository.save(basketProduct);
        });
    }

    @Test
    public void testUpdateBasket() {
        Goods goods = new Goods();
        goods = goodsRepository.findGoodsByGid(1L);

        BasketProduct basketProduct = new BasketProduct();
        basketProduct.setBid(1L);
        basketProduct.setQuantity(10);
        basketProduct.setGoods(goods);
        basketRepository.save(basketProduct);

        basketProduct.setQuantity(2);
        basketRepository.save(basketProduct);
        int n = basketRepository.findBasketProductByBid(1L).getQuantity();

        assertThat(2,is(n));
    }
}
