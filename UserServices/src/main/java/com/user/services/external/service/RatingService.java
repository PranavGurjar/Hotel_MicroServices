package com.user.services.external.service;

import com.user.services.entites.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    //get
    @GetMapping("/ratings/{ratingId}")
    Rating getRating(@PathVariable("ratingId") String ratingId);

    //post
    @PostMapping("/ratings")
    Rating createRating(Rating values);
    //@PostMapping("/ratings")
    //ResponseEntity<Rating> createRating(Rating values);

    //put
    @PutMapping("/ratings/{ratingId}")
    Rating updateRating(@PathVariable("ratingId") String ratingId, Rating rating);

    //delete
    @DeleteMapping("/ratings/{ratingId}")
    Rating deleteRating(@PathVariable("ratingId") String ratingId);
}
