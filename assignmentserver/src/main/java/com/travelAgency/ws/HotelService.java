package com.travelAgency.ws;

import com.travelAgency.model.Hotel;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface HotelService {
    @WebMethod
    public boolean addHotel(Hotel p);

    @WebMethod
    public Hotel getHotel(int id);
}
