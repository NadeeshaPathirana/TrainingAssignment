package com.travelAgency.ws;

import com.travelAgency.model.RoomType;

import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;

@WebService
public class RoomTypeServiceImple implements RoomTypeService{

    private static Map<Integer, RoomType> room_types = new HashMap<Integer,RoomType>();

    public boolean addRoomType(RoomType roomType) {
        System.out.println("Room type is added");
        room_types.put(roomType.getRoom_type_id(), roomType);
        return true;
    }

    public RoomType getRoomType(int id) {
        return room_types.get(id);
    }
}
