package com.senla.elhoteladmin.service;

import com.senla.elhoteladmin.configuration.ConfigProperty;
import com.senla.elhoteladmin.configuration.ConfigUtil;
import com.senla.elhoteladmin.dao.IRoomRepo;
import com.senla.elhoteladmin.entity.Room;
import depinject.DepInjReflectUtil;
import depinject.DependencyInjection;

import java.util.List;

public class RoomService implements IRoomService {
    @DependencyInjection
    private IRoomRepo roomRepo;

    private static RoomService instance;

    public static synchronized RoomService getInstance() {
        if (instance == null) {
            instance = new RoomService();
        }
        return instance;
    }

    @ConfigProperty
    private Boolean roomStatusChange;

    private RoomService() {
        DepInjReflectUtil.initializeDepInjection(this);
        ConfigUtil.initializeProperties(this);
    }

    @Override
    public Boolean getRoomStatusChange() {
        return roomStatusChange;
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
    public void saveNewRoom(Room room) {
        roomRepo.save(room);
    }

    @Override
    public void deleteRoom(Room room) {
        roomRepo.delete(room);
    }

    @Override
    public List<Room> getRoomsList() {
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
    public void updateRoom(Room room) {
        roomRepo.update(room);
    }

    @Override
    public void deserializeListRoom(List<Room> list) {
        roomRepo.deserializeListRoom(list);
    }
}
