package com.bigplex.bigplex.subscription.converter;

import com.bigplex.bigplex.subscription.dto.SubscriptionDto;
import com.bigplex.bigplex.subscription.model.Subscription;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SubConverter {
    public SubscriptionDto entityToDto(Subscription subscription){
        SubscriptionDto subscriptionDto =new SubscriptionDto();
        subscriptionDto.setPackId(subscription.getPackId());
        subscriptionDto.setEndDate(subscription.getEndDate());
        subscriptionDto.setPackName(subscription.getPackName());
        subscriptionDto.setSizeAvailable(subscription.getSizeAvailable());
        subscriptionDto.setSizeUsed(subscription.getSizeUsed());
        subscriptionDto.setStartDate(subscription.getStartDate());
        subscriptionDto.setSubId(subscription.getSubId());
        subscriptionDto.setSubStatus(subscription.getSubStatus());
        subscriptionDto.setUserId(subscription.getUserId());
        subscriptionDto.setUserName(subscription.getUserName());
        return subscriptionDto;
    }

    public Subscription dtoToEntity(SubscriptionDto subscriptionDto){
        Subscription subscription =new Subscription();
        subscription.setEndDate(subscriptionDto.getEndDate());
        subscription.setPackId(subscriptionDto.getPackId());
        subscription.setPackName(subscriptionDto.getPackName());
        subscription.setSizeAvailable(subscriptionDto.getSizeAvailable());
        subscription.setSizeUsed(subscriptionDto.getSizeUsed());
        subscription.setStartDate(subscriptionDto.getStartDate());
        subscription.setUserId(subscriptionDto.getUserId());
        subscription.setSubStatus(subscriptionDto.getSubStatus());
        subscription.setUserName(subscriptionDto.getUserName());
        return subscription;
    }

    public List<SubscriptionDto> entityToDto(List<Subscription> subscriptionList){
        return subscriptionList.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public List<Subscription> dtoToEntity(List<SubscriptionDto> subscriptionDtoList){
        return subscriptionDtoList.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }
}
