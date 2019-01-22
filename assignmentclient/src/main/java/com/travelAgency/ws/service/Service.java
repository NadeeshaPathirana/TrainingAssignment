package com.travelAgency.ws.service;
import java.util.Arrays;

import com.travelAgency.ws.hotel.Hotel;
import com.travelAgency.ws.hotel.HotelServiceImpl;
import com.travelAgency.ws.hotel.HotelServiceImplService;

public class Service {
    public static void main(String[] args){
        HotelServiceImplService serviceImpl = new HotelServiceImplService();
        HotelServiceImpl service = serviceImpl.getHotelServiceImplPort();

        Hotel hotel_1 = new Hotel();
        hotel_1.setId(1);

        Hotel hotel_2 = new Hotel();
        hotel_2.setId(2);

        System.out.println("Add hotel Status="+service.addHotel(hotel_1));
        System.out.println("Add hotel Status="+service.addHotel(hotel_2));

        //get hotel
        System.out.println("Hotel="+service.getHotel(1));
    }
}
