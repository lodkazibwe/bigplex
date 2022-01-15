package com.bigplex.bigplex.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDto {
    private int detailId;
    private int movieId;
    private String movieTitle;
    private String episodes;
    private double size;
    private String comment;
}
