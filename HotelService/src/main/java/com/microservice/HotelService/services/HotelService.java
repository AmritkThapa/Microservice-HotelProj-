package com.microservice.HotelService.services;

import com.microservice.HotelService.entities.Hotel;

import java.util.List;

public interface HotelService {

    //create
    Hotel create(Hotel hotel);

    //getall
    List<Hotel> getAll();

    //get Single
    Hotel get(String id);
}
