package com.microservice.UserService.external.services;

import com.microservice.UserService.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "RATING-SERVICES")
public interface RatingService {

    //Get
    @GetMapping("/ratings/users/{ratingId}")
    Rating getRating(@PathVariable String ratingId);

    //Post
    @PostMapping("/ratings")
    Rating createRating(/*ap<String, Object> or*/Rating values);

    //PUT
    @PutMapping("/ratings/{ratingId}")
    Rating updateRating(@PathVariable("ratingId") String ratingId, Rating rating);

    @DeleteMapping("ratings/{ratingId}")
    void deleteRating(@PathVariable String ratingId);
}
