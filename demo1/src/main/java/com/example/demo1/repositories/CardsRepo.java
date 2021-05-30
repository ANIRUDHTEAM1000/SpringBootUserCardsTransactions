package com.example.demo1.repositories;


import com.example.demo1.models.Cards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardsRepo extends JpaRepository<Cards,Long> {
}
