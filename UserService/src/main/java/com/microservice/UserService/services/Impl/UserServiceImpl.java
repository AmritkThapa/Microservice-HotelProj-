package com.microservice.UserService.services.Impl;

import com.microservice.UserService.entities.Hotel;
import com.microservice.UserService.entities.Rating;
import com.microservice.UserService.entities.User;
import com.microservice.UserService.external.services.HotelService;
import com.microservice.UserService.external.services.RatingService;
import com.microservice.UserService.repositories.UserRepo;
import com.microservice.UserService.services.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final RestTemplate restTemplate;
    private final HotelService hotelService;
    private final RatingService ratingService;
    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Override
    public User saveUser(User user) {
        //generate unique userid
        String randomUserID = UUID.randomUUID().toString();
        user.setUserId(randomUserID);
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        List<User> user =  userRepo.findAll();
        ArrayList<Rating> Ratings = restTemplate.getForObject("http://localhost:8083/ratings", ArrayList.class);
        return user;
    }


    @Override
    public User getUser(String userId) {
        //get user from database with user repository
        User user = userRepo.findById(userId).orElseThrow(()-> new ResourceAccessException("No user with given id:" +userId));
        //fetch rating of above user from Rating-Service
        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICES/ratings/users/"+user.getUserId(), Rating[].class);
        //Rating ratingsOfUser = ratingService.getRating();
        logger.info("{}",ratingsOfUser);

        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

        List<Rating> ratingList = ratings.stream().map(rating -> {
            //api call to hotel service to get the hotel
            //http://localhost:8082/hotels/669d8823-206e-4008-b36d-da6cf4557a43
//            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICES/hotels/"+rating.getHotelId(),Hotel.class);
            Hotel hotel=hotelService.getHotel(rating.getHotelId());

            //set the hotel to rating
            rating.setHotel(hotel);
            //return the rating
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratingList);
        return user;
    }
}
