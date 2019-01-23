package com.travelAgency.dao;

import java.util.List;
import com.travelAgency.model.RoomType;

public interface RoomTypeDao {
    int save(RoomType roomType);
    RoomType get(int id);
    List<RoomType> list();
}
