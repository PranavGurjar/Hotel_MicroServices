package com.hotel.services.service;

import com.hotel.services.entities.Hotel;

import java.util.List;

public interface HotelService {
    //create
    Hotel create(Hotel hotel);

    //getAll
    List<Hotel> getAll();

    //get single
    Hotel get(String id);
}
