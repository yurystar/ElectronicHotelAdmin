package com.senla.daoservice.service;

import com.senla.daoservice.entity.Room;

import java.util.List;

public interface IRoomService {

    List<Room> getHotelRoomsSortedByRoomPlaces();

    List<Room> getHotelRoomsSortedByRoomPrice();

    List<Room> getHotelRoomsSortedByRoomType();

    List<Room> getEmptyHotelRoomsSortedByRoomPlaces();

    List<Room> getEmptyHotelRoomsSortedByRoomPrice();

    List<Room> getEmptyHotelRoomsSortedByRoomType();

    long getNumberEmptyHotelRooms();

    void saveNewRoom(Room room);

    void deleteRoom(Room room);

    List<Room> getRoomsList();

    void setNewPriceRoom(Integer roomNumber, Integer priceRoom);

    Room getRoomByNum(Integer roomNumber);

    void updateRoom(Room room);

    void deserializeListRoom(List<Room> list);

    public Boolean getRoomStatusChange();
}
