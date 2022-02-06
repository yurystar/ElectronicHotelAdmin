package com.senla.daoservice.entity;

import java.io.Serializable;
import java.util.Objects;

public class Room implements Serializable {
    private static final long serialVersionUID = 4L;

    private Integer roomID;
    private Integer roomNumber;
    private RoomType roomType;
    private Integer roomPlaces;
    private Integer roomPrice;
    private RoomStatus roomStatus;

    public Room() {
    }

    public Room(Integer roomID, Integer roomNumber, RoomType roomType,
                Integer roomPlaces, Integer roomPrice) {
        this.roomID = roomID;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.roomPlaces = roomPlaces;
        this.roomPrice = roomPrice;
        this.roomStatus = RoomStatus.EMPTY;
    }

    public Integer getRoomID() {
        return roomID;
    }

    public void setRoomID(Integer roomID) {
        this.roomID = roomID;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public Integer getRoomPlaces() {
        return roomPlaces;
    }

    public void setRoomPlaces(Integer roomPlaces) {
        this.roomPlaces = roomPlaces;
    }

    public Integer getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(Integer roomPrice) {
        this.roomPrice = roomPrice;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return getRoomID().equals(room.getRoomID()) && getRoomNumber().equals(room.getRoomNumber())
                && getRoomType() == room.getRoomType() && getRoomPlaces().equals(room.getRoomPlaces())
                && getRoomPrice().equals(room.getRoomPrice()) && getRoomStatus() == room.getRoomStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoomID(), getRoomNumber(), getRoomType(), getRoomPlaces(),
                getRoomPrice(), getRoomStatus());
    }

    @Override
    public String toString() {
        return "\nRoom{" +
                "roomID=" + roomID +
                ", roomNumber=" + roomNumber +
                ", roomType=" + roomType +
                ", roomPlaces=" + roomPlaces +
                ", roomPrice=" + roomPrice +
                ", roomStatus=" + roomStatus +
                '}';
    }
}
