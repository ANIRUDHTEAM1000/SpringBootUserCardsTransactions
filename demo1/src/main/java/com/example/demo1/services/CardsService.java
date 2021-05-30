package com.example.demo1.services;

import com.example.demo1.models.Cards;
import com.example.demo1.models.User;
import com.example.demo1.repositories.CardsRepo;
import com.example.demo1.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardsService {
    @Autowired
    CardsRepo cardsRepo;
    @Autowired
    UserRepo userRepo;

    public Long getTotalUserBalance(Long uid) {
        Long res=0L;
        User u=userRepo.findById(uid).get();
        for(Cards card:u.getCards())
        {
            res=res+card.getBalance();
        }
        return res;
    }
}
