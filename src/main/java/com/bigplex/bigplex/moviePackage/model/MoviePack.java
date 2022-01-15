package com.bigplex.bigplex.moviePackage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MoviePack {
    @Id
    @GeneratedValue
    private int packId;
    @Column(unique=true)
    private String name;
    private double price;
    private int duration;
    private double size;
    private String packStatus;
        
}
