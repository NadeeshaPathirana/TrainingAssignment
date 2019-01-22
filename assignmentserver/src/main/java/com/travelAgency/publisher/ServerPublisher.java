package com.travelAgency.publisher;
import com.travelAgency.ws.HotelServiceImpl;

import javax.xml.ws.Endpoint;

public class ServerPublisher {
    public static void main(String[] args){
        Endpoint.publish("http://localhost:8888/ws/hotel", new HotelServiceImpl());
    }
}
