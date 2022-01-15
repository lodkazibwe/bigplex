package com.bigplex.bigplex.subscription.service.impl;

import com.bigplex.bigplex.exceptions.ResourceNotFoundException;
import com.bigplex.bigplex.moviePackage.model.MoviePack;
import com.bigplex.bigplex.moviePackage.service.MoviePackService;
import com.bigplex.bigplex.subscription.converter.SubConverter;
import com.bigplex.bigplex.subscription.dao.SubscriptionDao;
import com.bigplex.bigplex.subscription.dto.SubscriptionDto;
import com.bigplex.bigplex.subscription.model.Subscription;
import com.bigplex.bigplex.subscription.service.SubscriptionService;
import com.bigplex.bigplex.user.model.Profile;
import com.bigplex.bigplex.user.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Autowired SubscriptionDao subscriptionDao;
    @Autowired SubConverter subConverter;
    @Autowired ProfileService profileService;
    @Autowired MoviePackService moviePackService;


    @Override
    public Subscription addNew(SubscriptionDto subscriptionDto) {
        return subscriptionDao.save(subConverter.dtoToEntity(subscriptionDto));
    }

    @Override
    public Subscription subscribe(int userId, int packId) {
        Profile user =profileService.getUser(userId);
        MoviePack moviePack =moviePackService.getPackage(packId);
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, moviePack.getDuration());

        SubscriptionDto subscriptionDto =new SubscriptionDto();
        subscriptionDto.setUserId(user.getUserId());
        subscriptionDto.setUserName(user.getUserName());
        subscriptionDto.setSubStatus("NEW");
        subscriptionDto.setSubId(0);
        subscriptionDto.setStartDate(new Date());
        subscriptionDto.setSizeUsed(0);
        subscriptionDto.setSizeAvailable(moviePack.getSize());
        subscriptionDto.setPackName(moviePack.getName());
        subscriptionDto.setPackId(moviePack.getPackId());
        subscriptionDto.setEndDate(cal.getTime());
        return addNew(subscriptionDto);
    }

    @Override
    public Subscription getSubscription(int subId) {

        return subscriptionDao.findById(subId)
                .orElseThrow(()->new ResourceNotFoundException("no such subscription "+subId));
    }

    @Override
    public List<Subscription> getUserAll(int userId) {

        return subscriptionDao.findByUserId(userId);
    }

    @Override
    public List<Subscription> getPackAll(int packId) {

        return subscriptionDao.findByPackId(packId);
    }
}
