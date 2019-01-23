package com.travelAgency.dao;

import java.util.List;
import com.travelAgency.model.Hotel;

public interface HotelDao {
    int save(Hotel hotel);
    Hotel get(int id);
    List<Hotel> list();

}
