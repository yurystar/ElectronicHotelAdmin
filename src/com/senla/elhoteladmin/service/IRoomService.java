package com.senla.elhoteladmin.service;

import com.senla.elhoteladmin.entity.Room;

import java.util.List;

public interface IRoomService {

    List<Room> getHotelRoomsSortedByRoomPlaces();

    List<Room> getHotelRoomsSortedByRoomPrice();

    List<Room> getHotelRoomsSortedByRoomType();

    List<Room> getEmptyHotelRoomsSortedByRoomPlaces();

    List<Room> getEmptyHotelRoomsSortedByRoomPrice();

    List<Room> getEmptyHotelRoomsSortedByRoomType();

    long getNumberEmptyHotelRooms();

    void setNewRoom(Room room);

    void deleteRoom(Room room);

    Room getRoomByNumber(Integer roomNumber);

    List<Room> getRoomList();

    void setNewPriceRoom(Integer roomNumber, Integer priceRoom);

    Room getRoomByNum(Integer roomNumber);

    void deserializeListRoom(List<Room> list);
}
