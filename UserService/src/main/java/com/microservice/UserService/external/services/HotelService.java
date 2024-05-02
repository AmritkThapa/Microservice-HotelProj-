package com.microservice.UserService.external.services;

import com.microservice.UserService.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICES")
public interface HotelService
{
    @GetMapping("/hotels/{hotelId}")
    Hotel getHotel(@PathVariable("hotelId") String hotelId);
}