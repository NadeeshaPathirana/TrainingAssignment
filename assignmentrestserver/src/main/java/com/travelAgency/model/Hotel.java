package com.travelAgency.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "NP_HOTEL")
public class Hotel implements Serializable {

    private static final long serialVersionUID = -723583058586873479L;

    @Id
    @Column(name = "HOTEL_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hotelId;

    @Column(name = "HOTEL_NAME")
    private String hotelName;

    @OneToMany(mappedBy = "NP_HOTEL", cascade = CascadeType.ALL)
    private List<RoomType> roomTypes;


    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public List<RoomType> getRoomTypes() {
        return roomTypes;
    }

    public void setRoomTypes(List<RoomType> roomTypes) {
        this.roomTypes = roomTypes;
    }
}
