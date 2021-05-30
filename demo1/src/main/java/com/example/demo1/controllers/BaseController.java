package com.example.demo1.controllers;


import com.example.demo1.models.Transactions;
import com.example.demo1.models.User;
import com.example.demo1.repositories.CardsRepo;
import com.example.demo1.repositories.TransactionsRepo;
import com.example.demo1.repositories.UserRepo;
import com.example.demo1.services.CardsService;
import com.example.demo1.services.TransactionsService;
import com.example.demo1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class BaseController {
    @Autowired
    UserService userService;
    @Autowired
    CardsService cardsService;
    @Autowired
    TransactionsService transactionsService;

    @PostMapping(value = "/user/add")
    public User add(@RequestBody User u)
    {
        return userService.add(u);
    }

    @PostMapping(value = "/transaction/add/{cid}")
    public Transactions add(@RequestBody Transactions t,@PathVariable Long cid)
    {
        return transactionsService.addTransaction(cid,t);
    }


    @GetMapping(value = "/transaction/searchby/{s}")
    public List<Transactions> search(@PathVariable String s)
    {
        return transactionsService.searchByString(s);
    }

    @GetMapping(value = "/balance/{uid}")
    public Long balance(@PathVariable Long uid)
    {
       return cardsService.getTotalUserBalance(uid);
    }


}