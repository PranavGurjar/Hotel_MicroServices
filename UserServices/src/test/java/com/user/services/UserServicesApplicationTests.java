package com.user.services;

import com.user.services.entites.Rating;
import com.user.services.external.service.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class UserServicesApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private RatingService ratingService;

//	@Test
//	void createRating(){
//
//		Rating rating = Rating.builder().rating(10).userId("").hotelId("").feedback("This is build using feign client.").build();
//		Rating saveRating = ratingService.createRating(rating);
//		System.out.println("new rating created");
//	}


//	@Test
//	void createRating(){
//
//		Rating rating = Rating.builder().rating(10).userId("").hotelId("").feedback("This is build using feign client.").build();
//		ResponseEntity<Rating> ratingResponseEntity = ratingService.createRating(rating);
//		HttpStatusCode statusCode = ratingResponseEntity.getStatusCode();
//		System.out.println("new rating created"+statusCode);
//	}

}
