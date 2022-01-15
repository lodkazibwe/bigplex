package com.bigplex.bigplex.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MovieOrder {
    @Id
    @GeneratedValue
    private int orderId;
    private int subId;
    private String userName;
    private String orderStatus;
    private double size;
    @OneToMany(targetEntity = OrderDetail.class,cascade= CascadeType.ALL, fetch= FetchType.EAGER)
     @JoinColumn()
    private List<OrderDetail> orderDetails;

}
