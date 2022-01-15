package com.bigplex.bigplex.order.converter;

import com.bigplex.bigplex.order.dto.OrderDetailDto;
import com.bigplex.bigplex.order.model.OrderDetail;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderDetailConverter {
    public OrderDetailDto entityToDto(OrderDetail orderDetail){
        OrderDetailDto orderDetailDto =new OrderDetailDto();
        orderDetailDto.setDetailId(orderDetail.getDetailId());
        orderDetailDto.setComment(orderDetail.getComment());
        orderDetailDto.setMovieId(orderDetail.getMovieId());
        orderDetailDto.setMovieTitle(orderDetail.getMovieTitle());
        orderDetailDto.setSize(orderDetail.getSize());
        orderDetailDto.setEpisodes(orderDetail.getEpisodes());
        return orderDetailDto;
    }

    public OrderDetail dtoToEntity(OrderDetailDto orderDetailDto){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setSize(orderDetailDto.getSize());
        orderDetail.setComment(orderDetailDto.getComment());
        orderDetail.setEpisodes(orderDetailDto.getEpisodes());
        orderDetail.setMovieId(orderDetailDto.getMovieId());
        orderDetail.setMovieTitle(orderDetailDto.getMovieTitle());
        return orderDetail;
    }

    public List<OrderDetailDto> entityToDto(List<OrderDetail> orderDetailList){
        return orderDetailList.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public List<OrderDetail> dtoToEntity(List<OrderDetailDto> orderDetailDtoList){
        return orderDetailDtoList.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }
}
