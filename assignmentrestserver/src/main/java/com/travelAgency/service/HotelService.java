package com.travelAgency.service;

import java.util.List;
import com.travelAgency.model.Hotel;

public interface HotelService {
    int save(Hotel hotel);
    Hotel get(int id);
    List<Hotel> list();
}
