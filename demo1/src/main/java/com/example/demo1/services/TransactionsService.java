package com.example.demo1.services;


import com.example.demo1.models.Cards;
import com.example.demo1.models.Transactions;
import com.example.demo1.repositories.CardsRepo;
import com.example.demo1.repositories.TransactionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class TransactionsService {
    @Autowired
    TransactionsRepo transactionsRepo;
    @Autowired
    CardsRepo cardsRepo;
    public Transactions addTransaction(Long cid, Transactions t) {
        Cards c=cardsRepo.findById(cid).get();
        List<Transactions> transactions=c.getTransactions();
        transactions.add(t);
        c.setTransactions(transactions);
        c.setBalance(c.getBalance()+t.getTamount());
        cardsRepo.save(c);
        return t;
    }

    public List<Transactions> searchByString(String s) {
       return    transactionsRepo.searchByString(s.toLowerCase());
    }
}
