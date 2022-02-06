package com.senla.daoservice.controller;

import com.senla.daoservice.entity.*;

import java.time.LocalDate;
import java.util.List;

public interface IAdminController {

    AdditionalService getAdditionalServiceByID(Integer serviceID);

    void saveNewBookingOrder(BookingOrder order);

    List<Room> getEmptyHotelRoomsListOnDate(LocalDate date);

    void checkInOrder(Integer orderID);

    void checkOutOrder(Integer orderID);

    public void setRoomStatusAsOnRepair(Integer roomNumber);

    public void setRoomStatusAsEmpty(Integer roomNumber);

    public List<BookingOrder> getListGuestsAndTheirRoomsSortedByRoom();

    public List<BookingOrder> getListGuestsAndTheirRoomsSortedByCheckOutDays();

    public Long getOrderPrice(Integer orderID);

    public List<AdditionalService> getListAdditionalServices();

    public Room getRoomByNum(Integer roomNumber);

    public void deleteBookingOrderByID(Integer orderID);

    public void deserializeListAddServ(List<AdditionalService> list);

    public void deserializeListBookingOrder(List<BookingOrder> list);

    public void deserializeListGuest(List<Guest> list);

    public void deserializeListRoom(List<Room> list);


    List<AdditionalService> getListAdditionalServicesSortedByPrice();

    void saveNewAdditionalService(AdditionalService additionalService);

    void deleteAdditionalService(AdditionalService additionalService);

    void updateAdditionalService(AdditionalService additionalService);

    List<BookingOrder> getLastThreeGuestsRoom(Integer roomNumber);

    List<BookingOrder> getListBookingOrders();

    List<AdditionalService> getListAdditionalServiceOfGuestSortedByPrice(Integer guestID);

    BookingOrder getBookingOrderByID(Integer bookingOrderID);

    void updateBookingOrder(BookingOrder bookingOrder);


    List<Guest> getGuestsHotel();

    long getNumberGuestsHotel();

    void saveGuestInStorage(Guest guest);

    void removeGuestFromStorage(Guest guest);

    Guest getGuestById(Integer guestID);

    void updateGuest(Guest guest);


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

    void updateRoom(Room room);

    public Boolean getRoomStatusChange();
}
