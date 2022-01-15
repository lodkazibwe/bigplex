package com.bigplex.bigplex.order.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieOrderDto {
    private int orderId;
    private int subId;
    private String userName;
    private String orderStatus;
    private double size;
    private List<OrderDetailDto> orderDetails;
}
