package com.example.test1.controller;

import com.example.test1.domain.Goods;
import com.example.test1.domain.Option;
import com.example.test1.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    GoodService service;

    @GetMapping("/{id}")
    public String getGoods(@PathVariable Long id, Model model) {
        Goods goods = service.getGoods(id);
        model.addAttribute("vo",goods);

        List<Option> list = service.getOption(id);
        model.addAttribute("optionList",list);
        return "goodDetail";
    }

    @GetMapping("/list")
    public String getGoodsList(Model model) {
        List<Goods> list = service.getAllGoods();
        model.addAttribute("list",list);
        return "goodList";
    }
}
