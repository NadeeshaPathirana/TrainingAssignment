package com.travelAgency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.travelAgency.model.RoomType;
import com.travelAgency.service.RoomTypeService;

@RestController
@RequestMapping(value = "/roomType")
public class RoomTypeController {
    @Autowired
    private RoomTypeService roomTypeService;

    @GetMapping("/getRoomType/{id}")
    public ResponseEntity<RoomType> get(@PathVariable("id") int id){
        RoomType roomType = roomTypeService.get(id);
        return ResponseEntity.ok().body(roomType);
    }
}
