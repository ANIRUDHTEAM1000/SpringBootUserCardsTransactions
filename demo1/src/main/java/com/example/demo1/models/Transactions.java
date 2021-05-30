package com.example.demo1.models;

import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tid;
    private String description;
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date date;
    @NotNull
    private Long tamount;
}