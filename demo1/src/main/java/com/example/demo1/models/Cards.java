package com.example.demo1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Cards {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cid;
    private Long Balance;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    @JsonIgnore
    private List<Transactions> transactions;
}