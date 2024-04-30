package com.microservices.RatingsInfo.services;

import com.microservices.RatingsInfo.entities.Rating;

import java.util.List;

public interface RatingService {
    //create
    Rating create(Rating rating);

    //get all
    List<Rating> getRatings();

    //get all rating by user
    List<Rating> getRatingsByUserId(String userId);

    //get all ratings of hotel
    List<Rating> getRatingsByHotelId(String hotelId);
}
