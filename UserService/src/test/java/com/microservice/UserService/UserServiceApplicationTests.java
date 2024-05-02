package com.microservice.UserService;

import com.microservice.UserService.entities.Rating;
import com.microservice.UserService.external.services.RatingService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

@SpringBootTest
//@Service
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	//Feign client post testing:
//	@Autowired
//	private RatingService ratingService;
//
//	@Test
//	void createRating(){
//		Rating rating = Rating.builder().rating(8).userId("").hotelId("").feedback("Feign Client Test").build();
//		Rating savedRating = ratingService.createRating(rating);
//		System.out.println("new"+savedRating);
//	}

}
