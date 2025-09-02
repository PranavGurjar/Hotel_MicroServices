package com.user.services.controller;

import com.user.services.entites.User;
import com.user.services.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    //create
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    //single user get
    @GetMapping("/{userId}")
    // @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
    @Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId){
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    //creating fall back method for circuit breaker
    int retryCount = 1;
    public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex){
        // logger.info("Fallback is executed because service is down : ", ex.getMessage());
        logger.info("Retry count: {}",retryCount);
        retryCount++;
        User user = User.builder()
                        .email("dummy@gmail.com")
                        .name("dummy")
                        .about("This user is created dummy because some service is down")
                        .userId("1234")
                        .build();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    //all user get
    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }



}
