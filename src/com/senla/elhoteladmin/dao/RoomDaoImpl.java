package com.senla.elhoteladmin.dao;

import com.senla.elhoteladmin.entity.Room;
import com.senla.elhoteladmin.entity.RoomStatus;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RoomDaoImpl implements IRoomRepo {
    private static RoomDaoImpl instance;

    public static synchronized RoomDaoImpl getInstance() {
        if (instance == null) {
            instance = new RoomDaoImpl();
        }
        return instance;
    }

    private List<Room> rooms = new ArrayList<>();

    @Override
    public Room get(Integer roomID) {
        return rooms.stream()
                .filter(room -> room.getRoomID().equals(roomID))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Room getRoomByNum(Integer roomNumber) {
        return rooms.stream()
                .filter(room -> room.getRoomNumber().equals(roomNumber))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Room> getAll() {
        return rooms;
    }

    @Override
    public void save(Room room) {
        rooms.add(room);
    }

    @Override
    public void update(Room room) {
        if (!rooms.contains(room)) {
            Room tmpRoom = getRoomByNum(room.getRoomNumber());
            rooms.remove(tmpRoom);
            rooms.add(room);
        } else {
            System.out.println("Such an object already exists!");
        }
    }

    @Override
    public void delete(Room room) {
        rooms.remove(room);
    }

    @Override
    public List<Room> getHotelRoomsSortedList(Comparator<Room> comparing) {
        return rooms.stream()
                .sorted(comparing)
                .collect(Collectors.toList());
    }

    @Override
    public List<Room> getHotelRoomsSortedByRoomPlaces() {
        return getHotelRoomsSortedList(Comparator.comparingInt(Room::getRoomPlaces));
    }

    @Override
    public List<Room> getHotelRoomsSortedByRoomPrice() {
        return getHotelRoomsSortedList(Comparator.comparingInt(Room::getRoomPrice));
    }

    @Override
    public List<Room> getHotelRoomsSortedByRoomType() {
        return getHotelRoomsSortedList(Comparator.comparing(Room::getRoomType));
    }

    @Override
    public List<Room> getEmptyHotelRoomsSortedList(Comparator<Room> comparing) {
        return rooms.stream()
                .filter(room -> room.getRoomStatus().equals(RoomStatus.EMPTY))
                .sorted(comparing)
                .collect(Collectors.toList());
    }

    @Override
    public List<Room> getEmptyHotelRoomsSortedByRoomPlaces() {
        return getEmptyHotelRoomsSortedList(Comparator.comparing(Room::getRoomPlaces));
    }

    @Override
    public List<Room> getEmptyHotelRoomsSortedByRoomPrice() {
        return getEmptyHotelRoomsSortedList(Comparator.comparingInt(Room::getRoomPrice));
    }

    @Override
    public List<Room> getEmptyHotelRoomsSortedByRoomType() {
        return getEmptyHotelRoomsSortedList(Comparator.comparing(Room::getRoomType));
    }

    @Override
    public long getNumberEmptyHotelRooms() {
        return rooms.stream()
                .filter(room -> room.getRoomStatus().equals(RoomStatus.EMPTY))
                .count();
    }

    @Override
    public void setNewPriceRoom(Integer roomNumber, Integer priceRoom) {
        for (Room room : rooms) {
            if (room.getRoomNumber().equals(roomNumber)) {
                room.setRoomPrice(priceRoom);
            }
        }
    }

    @Override
    public void deserializeListRoom(List<Room> list) {
        RoomDaoImpl.getInstance().rooms = new ArrayList<>(list);
    }
}
