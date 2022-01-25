package com.senla.elhoteladmin.service;

import com.senla.elhoteladmin.dao.IRoomRepo;
import com.senla.elhoteladmin.dao.RoomDaoImpl;
import com.senla.elhoteladmin.entity.Room;

import java.util.List;

public class RoomService implements IRoomService {
    private static RoomService instance;

    public static synchronized RoomService getInstance() {
        if (instance == null) {
            instance = new RoomService();
        }
        return instance;
    }

    private final IRoomRepo roomRepo;

    public RoomService() {
        this.roomRepo = RoomDaoImpl.getInstance();
    }

    @Override
    public List<Room> getHotelRoomsSortedByRoomPlaces() {
        return roomRepo.getHotelRoomsSortedByRoomPlaces();
    }

    @Override
    public List<Room> getHotelRoomsSortedByRoomPrice() {
        return roomRepo.getHotelRoomsSortedByRoomPrice();
    }

    @Override
    public List<Room> getHotelRoomsSortedByRoomType() {
        return roomRepo.getHotelRoomsSortedByRoomType();
    }

    @Override
    public List<Room> getEmptyHotelRoomsSortedByRoomPlaces() {
        return roomRepo.getEmptyHotelRoomsSortedByRoomPlaces();
    }

    @Override
    public List<Room> getEmptyHotelRoomsSortedByRoomPrice() {
        return roomRepo.getEmptyHotelRoomsSortedByRoomPrice();
    }

    @Override
    public List<Room> getEmptyHotelRoomsSortedByRoomType() {
        return roomRepo.getEmptyHotelRoomsSortedByRoomType();
    }

    @Override
    public long getNumberEmptyHotelRooms() {
        return roomRepo.getNumberEmptyHotelRooms();
    }

    @Override
    public void setNewRoom(Room room) {
        roomRepo.save(room);
    }

    @Override
    public void deleteRoom(Room room) {
        roomRepo.delete(room);
    }

    @Override
    public Room getRoomByNumber(Integer roomNumber) {
        return roomRepo.getAll().stream()
                .filter(room -> room.getRoomNumber().equals(roomNumber))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Room> getRoomList() {
        return roomRepo.getAll();
    }

    @Override
    public void setNewPriceRoom(Integer roomNumber, Integer priceRoom) {
        roomRepo.setNewPriceRoom(roomNumber, priceRoom);
    }

    @Override
    public Room getRoomByNum(Integer roomNumber) {
        return roomRepo.getRoomByNum(roomNumber);
    }

    @Override
    public void deserializeListRoom(List<Room> list) {
        roomRepo.deserializeListRoom(list);
    }
}
