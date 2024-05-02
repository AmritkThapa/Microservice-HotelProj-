package com.microservices.RatingsInfo.services.Impl;

import com.microservices.RatingsInfo.entities.Rating;
import com.microservices.RatingsInfo.repositories.RatingRepository;
import com.microservices.RatingsInfo.services.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {
    private final RatingRepository ratingRepository;
    //Create
    @Override
    public Rating create(Rating rating) {
        return ratingRepository.save(rating);
    }

    //Get all ratings
    @Override
    public List<Rating> getRatings() {
        return  ratingRepository.findAll();
    }

    //Get ratings by User
    @Override
    public List<Rating> getRatingsByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    //Get ratings of Hotels
    @Override
    public List<Rating> getRatingsByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
