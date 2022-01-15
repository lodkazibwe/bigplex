package com.bigplex.bigplex.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderDetail {
    @Id
    @GeneratedValue
    private int detailId;
    private int movieId;
    private String movieTitle;
    private String episodes;
    private double size;
    private String comment;

}
