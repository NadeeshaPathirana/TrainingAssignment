package com.travelAgency.model;

public class ContractRoomType {
    private int contract_room_type_id;
    private int contract_id;
    private int room_type_id;
    private int no_of_rooms;
    private double price;

    public int getContract_room_type_id() {
        return contract_room_type_id;
    }

    public void setContract_room_type_id(int contract_room_type_id) {
        this.contract_room_type_id = contract_room_type_id;
    }

    public int getContract_id() {
        return contract_id;
    }

    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    public int getRoom_type_id() {
        return room_type_id;
    }

    public void setRoom_type_id(int room_type_id) {
        this.room_type_id = room_type_id;
    }

    public int getNo_of_rooms() {
        return no_of_rooms;
    }

    public void setNo_of_rooms(int no_of_rooms) {
        this.no_of_rooms = no_of_rooms;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
