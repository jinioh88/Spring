package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
@RequestMapping("accounts")
public class TestController {
    @RequestMapping
    public String init() {
        return "form";
    }
    @RequestMapping(path = "account/{accountId}", method = RequestMethod.GET)
    public String detail(@PathVariable String accountId) {
        return "form";
    }

    @ModelAttribute(value = "default")
    public AccountCreateForm setUpForm() {
        return new AccountCreateForm();
    }

    @RequestMapping("create")
    public String form(Model model) {
        return "form";
    }

}
