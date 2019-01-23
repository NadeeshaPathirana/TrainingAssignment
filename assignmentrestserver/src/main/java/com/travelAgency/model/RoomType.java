package com.travelAgency.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "NP_ROOMTYPE")
public class RoomType implements Serializable {

    private static final long serialVersionUID = -723583058586873469L;

    @Id
    @Column(name = "ROOM_TYPE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomTypeId;

    @Column(name = "TYPE_NAME")
    private String typeName;

    @Column(name = "MAX_ADULTS")
    private int maxAdults;

    @ManyToOne
    private Hotel hotel;

    public int getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getMaxAdults() {
        return maxAdults;
    }

    public void setMaxAdults(int maxAdults) {
        this.maxAdults = maxAdults;
    }

}
