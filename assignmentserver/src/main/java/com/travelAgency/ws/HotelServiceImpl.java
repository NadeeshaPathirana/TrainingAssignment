package com.travelAgency.ws;

import com.travelAgency.model.Hotel;

import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;

@WebService
public class HotelServiceImpl implements HotelService{


    private static Map<Integer,Hotel> hotels = new HashMap<Integer,Hotel>();

    public boolean addHotel(Hotel h) {
        System.out.println("Hotel is added");
        hotels.put(h.getId(), h);
        return true;
    }

    public Hotel getHotel(int id) {
        return hotels.get(id);
    }
}

