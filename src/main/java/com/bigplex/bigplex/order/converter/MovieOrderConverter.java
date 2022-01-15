package com.bigplex.bigplex.order.converter;

import com.bigplex.bigplex.order.dto.MovieOrderDto;
import com.bigplex.bigplex.order.model.MovieOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieOrderConverter {
    @Autowired OrderDetailConverter orderDetailConverter;

    public MovieOrderDto entityToDto(MovieOrder movieOrder){
        MovieOrderDto movieOrderDto =new MovieOrderDto();
        movieOrderDto.setOrderId(movieOrder.getOrderId());
        movieOrderDto.setOrderDetails(orderDetailConverter.entityToDto(movieOrder.getOrderDetails()));
        movieOrderDto.setOrderStatus(movieOrder.getOrderStatus());
        movieOrderDto.setSize(movieOrder.getSize());
        movieOrderDto.setSubId(movieOrder.getSubId());
        movieOrderDto.setUserName(movieOrder.getUserName());
        return  movieOrderDto;
    }

    public MovieOrder dtoToEntity(MovieOrderDto movieOrderDto){
        MovieOrder movieOrder =new MovieOrder();
        movieOrder.setSize(movieOrderDto.getSize());
        movieOrder.setOrderDetails(orderDetailConverter.dtoToEntity(movieOrderDto.getOrderDetails()));
        movieOrder.setOrderStatus(movieOrderDto.getOrderStatus());
        movieOrder.setSubId(movieOrderDto.getSubId());
        movieOrder.setUserName(movieOrderDto.getUserName());
        return movieOrder;
    }

    public List<MovieOrderDto> entityToDto(List<MovieOrder> movieOrderList){
        return movieOrderList.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public List<MovieOrder> dtoToEntity(List<MovieOrderDto> movieOrderDtoList){
        return  movieOrderDtoList.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }
}
