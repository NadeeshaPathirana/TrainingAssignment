package com.travelAgency.service;

import java.util.List;
import com.travelAgency.model.RoomType;

public interface RoomTypeService {
    int save(RoomType roomType);
    RoomType get(int id);
    List<RoomType> list();
}
