package com.travelAgency.ws;

import com.travelAgency.model.Hotel;
import com.travelAgency.model.RoomType;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface RoomTypeService {
    @WebMethod
    public boolean addRoomType(RoomType roomType);

    @WebMethod
    public RoomType getRoomType(int id);

}
