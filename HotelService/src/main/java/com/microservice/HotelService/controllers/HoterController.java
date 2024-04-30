package com.microservice.HotelService.controllers;

import com.microservice.HotelService.entities.Hotel;
import com.microservice.HotelService.services.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
public class HoterController {
    private final HotelService hotelService;

    //create
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        String hotelID= UUID.randomUUID().toString();
        hotel.setId(hotelID);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }
    //get single
    @GetMapping("{hotelID}")
    public ResponseEntity<Hotel> tetHotel(@PathVariable String hotelID){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.get(hotelID));
    }
    //get all
    @GetMapping
    public ResponseEntity<List<Hotel>> getAll(){
        return ResponseEntity.ok(hotelService.getAll());
    }
}
