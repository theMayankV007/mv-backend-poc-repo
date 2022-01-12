package com.mayank.CSVDataLoaderDemo.dao;


import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Voltage {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "volt", precision = 10, scale = 4, nullable = false)
    private BigDecimal volt;

    @NotNull
    @Column(name = "time", nullable = false)
    private double time;

    public Voltage(BigDecimal volt, double time){
        this.volt = volt;
        this.time = time;
    }

}
