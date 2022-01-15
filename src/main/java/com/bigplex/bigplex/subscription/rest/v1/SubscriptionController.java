package com.bigplex.bigplex.subscription.rest.v1;

import com.bigplex.bigplex.subscription.converter.SubConverter;
import com.bigplex.bigplex.subscription.dto.SubscriptionDto;
import com.bigplex.bigplex.subscription.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/sub")
public class SubscriptionController {
    @Autowired SubConverter subConverter;
    @Autowired SubscriptionService subscriptionService;

    @PostMapping("/addNew")
    public ResponseEntity<SubscriptionDto> addNew(@Valid @RequestBody SubscriptionDto subscriptionDto){
        return new ResponseEntity<>(subConverter.entityToDto(subscriptionService.addNew(subscriptionDto)), HttpStatus.OK);
    }

    @PostMapping("/subscribe/{userId}/{packId}")
    public ResponseEntity<SubscriptionDto> subscribe(@PathVariable int userId, @PathVariable int packId){
        return new ResponseEntity<>(subConverter.entityToDto(subscriptionService.subscribe(userId, packId)), HttpStatus.OK);
    }

    @GetMapping("/getById/{subId}")
    public ResponseEntity<SubscriptionDto> getSubscription(@PathVariable int subId){
        return new ResponseEntity<>(subConverter.entityToDto(subscriptionService.getSubscription(subId)), HttpStatus.OK);
    }

    @GetMapping("/getByUser/{userId}")
    public ResponseEntity<List<SubscriptionDto>> getUserAll(@PathVariable int userId){
        return new ResponseEntity<>(subConverter.entityToDto(subscriptionService.getUserAll(userId)), HttpStatus.OK);
    }

    @GetMapping("/getByUser/{packId}")
    public ResponseEntity<List<SubscriptionDto>> getPackAll(@PathVariable int packId){
        return new ResponseEntity<>(subConverter.entityToDto(subscriptionService.getPackAll(packId)), HttpStatus.OK);
    }

}
