package com.travelAgency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.travelAgency.model.Hotel;
import com.travelAgency.service.HotelService;

@RestController
@RequestMapping(value = "/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

////    add a new hotel
//    @PostMapping("/addHotel")
//    public ResponseEntity<?> save(@RequestBody Hotel hotel){
//        System.out.println("this is the backend - hotel name : "+hotel.getHotelName());
//        int id = hotelService.save(hotel);
//        return ResponseEntity.ok().body("New hotel has been added. ID = "+id);
//    }

//    get a saved hotel
    @GetMapping("/getHotel/{id}")
    public ResponseEntity<Hotel> get(@PathVariable("id") int id){
        Hotel hotel = hotelService.get(id);
        return ResponseEntity.ok().body(hotel);
    }

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String welcome(){
//        return "Hi Welcome";
//    }

    @RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
    public String welcome_t(@PathVariable String username){
        return "Hi "+username+" ! ";
    }
}
