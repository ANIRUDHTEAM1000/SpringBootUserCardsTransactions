package com.example.demo1.models;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uid;
    @NotNull
    private String uname;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Cards> cards;

}
