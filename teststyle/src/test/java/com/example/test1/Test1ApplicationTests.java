package com.example.test1;

import com.example.test1.domain.Goods;
import com.example.test1.domain.Option;
import com.example.test1.domain.Shipping;
import com.example.test1.persistence.GoodsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test1ApplicationTests {
    @Autowired
    GoodsRepository repository;

    @Test
    public void contextLoads() {
        Goods good = new Goods();
        good.setName("패딩");
        good.setPrice(10000);
        good.setProvider("놀수페이스");

        Option option =  new Option();
        option.setColor("red");
        option.setSize("M");
        option.setStock(10);

        Option option2 =  new Option();
        option.setColor("red");
        option.setSize("L");
        option.setStock(10);
        good.setOptionList(Arrays.asList(option, option2));

        Shipping shipping = new Shipping();
        shipping.setPrice(2500);
        shipping.setCanbundle(true);
        shipping.setMethod("FREE");
        good.setShipping(shipping);

        repository.save(good);

    }

}
