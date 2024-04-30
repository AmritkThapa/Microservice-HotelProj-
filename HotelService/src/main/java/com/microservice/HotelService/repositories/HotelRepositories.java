package com.microservice.HotelService.repositories;

import com.microservice.HotelService.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepositories extends JpaRepository<Hotel, String> {
}
