package com.microservices.RatingsInfo.repositories;

import com.microservices.RatingsInfo.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
public interface RatingRepository extends MongoRepository<Rating, String> {

    //Custom Finder Method
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);
}
