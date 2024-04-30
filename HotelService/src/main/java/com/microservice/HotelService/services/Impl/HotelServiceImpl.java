package com.microservice.HotelService.services.Impl;

import com.microservice.HotelService.entities.Hotel;
import com.microservice.HotelService.exceptions.ResourceNotFoundException;
import com.microservice.HotelService.repositories.HotelRepositories;
import com.microservice.HotelService.services.HotelService;
import com.microservice.UserService.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepositories hotelRepositories;
    @Override
    public Hotel create(Hotel hotel) {
        return hotelRepositories.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepositories.findAll();
    }

    @Override
    public Hotel get(String id) {
        return hotelRepositories.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel with given id not found!"))

    }
}
