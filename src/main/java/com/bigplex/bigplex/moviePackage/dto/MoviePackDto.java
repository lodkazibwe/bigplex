package com.bigplex.bigplex.moviePackage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoviePackDto {
    private int packId;
    private String name;
    private double price;
    private int duration;
    private double size;
    private String packStatus;
}
