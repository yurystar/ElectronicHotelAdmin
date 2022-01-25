package com.senla.elhoteladmin.controller;

import com.senla.elhoteladmin.entity.*;
import com.senla.elhoteladmin.service.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class AdminControllerSingleton {

    private final IAdditionalServiceService additionalServiceService;
    private final IBookingOrderService bookingOrderService;
    private final IGuestService guestService;
    private final IRoomService roomService;

    private static AdminControllerSingleton instance;

    public static synchronized AdminControllerSingleton getInstance() {
                if (instance == null) {
                    instance = new AdminControllerSingleton();
        }
        return instance;
    }

    private AdminControllerSingleton() {
        this.additionalServiceService = AdditionalServiceService.getInstance();
        this.bookingOrderService = BookingOrderService.getInstance();
        this.guestService = GuestService.getInstance();
        this.roomService = RoomService.getInstance();
    }

    public Room getRoomByNumber(Integer roomNumber) {
        return roomService.getRoomByNumber(roomNumber);
    }

    public AdditionalService getAdditionalServiceByID(Integer serviceID) {
        return additionalServiceService.getAdditionalServiceByID(serviceID);
    }

    public void saveNewBookingOrder(BookingOrder order) {
        bookingOrderService.saveNewBookingOrder(order);
    }

    public List<Room> getEmptyHotelRoomsListOnDate(LocalDate date) {
        List<Room> roomsBusy = new ArrayList<>();
        for (BookingOrder bookingOrder : bookingOrderService.getListBookingOrders()) {
            if ((date.isAfter(bookingOrder.getOrderCheckInDate().minusDays(1))
                    && date.isBefore(bookingOrder.getOrderCheckOutDate().plusDays(1)))) {
                roomsBusy.add(bookingOrder.getOrderedHotelRoom());
            }
        }
        List<Room> EmptyHotelRoomsListOnDate = new ArrayList<>(roomService.getRoomList());
        EmptyHotelRoomsListOnDate.removeAll(roomsBusy);
        return EmptyHotelRoomsListOnDate;
    }

    public void checkInOrder(Integer orderID) {
        for (BookingOrder order : bookingOrderService.getListBookingOrders()) {
            if (order.getOrderID().equals(orderID)) {
                order.setOrderStatus(OrderStatus.CHECK_IN);
                for (Guest guest : order.getOrderHotelGuests()) {
                    guestService.addGuestInStorage(guest);
                }
                for (Room room : roomService.getRoomList()) {
                    if (room.getRoomNumber().equals(order.getOrderedHotelRoom().getRoomNumber())) {
                        room.setRoomStatus(RoomStatus.BUSY);
                    }
                }
            }
        }
    }

    public void checkOutOrder(Integer orderID) {
        for (BookingOrder order : bookingOrderService.getListBookingOrders()) {
            if (order.getOrderID().equals(orderID)) {
                order.setOrderStatus(OrderStatus.CHECK_OUT);
                for (Room room : roomService.getRoomList()) {
                    if (room.getRoomNumber().equals(order.getOrderedHotelRoom().getRoomNumber())) {
                        room.setRoomStatus(RoomStatus.EMPTY);
                    }
                }
//                }
            }
        }
    }

    public void setRoomStatusAsOnRepair(Integer roomNumber) {
        for (Room rooms : roomService.getRoomList()) {
            if (rooms.getRoomNumber().equals(roomNumber)
                    && !rooms.getRoomStatus().equals(RoomStatus.ON_REPAIR)
                    && !rooms.getRoomStatus().equals(RoomStatus.BUSY)) {
                rooms.setRoomStatus(RoomStatus.ON_REPAIR);
            }
        }
    }

    public void setRoomStatusAsEmpty(Integer roomNumber) {
        for (Room rooms : roomService.getRoomList()) {
            if (rooms.getRoomNumber().equals(roomNumber)
                    && rooms.getRoomStatus().equals(RoomStatus.ON_REPAIR)
                    && !rooms.getRoomStatus().equals(RoomStatus.BUSY)) {
                rooms.setRoomStatus(RoomStatus.EMPTY);
            }
        }
    }

    public List<BookingOrder> getListGuestsAndTheirRoomsSortedByRoom() {
        return bookingOrderService.getListGuestsAndTheirRoomsSortedByRoom();
    }

    public List<BookingOrder> getListGuestsAndTheirRoomsSortedByCheckOutDays() {
        return bookingOrderService.getListGuestsAndTheirRoomsSortedByCheckOutDays();
    }

    public Long getOrderPrice(Integer orderID) {
        Long res = null;
        for (BookingOrder order : bookingOrderService.getListBookingOrders()) {
            if (order.getOrderID().equals(orderID)) {
                res = ((order.getOrderedAdditionalServices()
                        .stream()
                        .mapToLong(AdditionalService::getServicePrice)
                        .sum()) + (order.getOrderedHotelRoom().getRoomPrice())) *
                        order.getOrderCheckOutDate().
                                until(order.getOrderCheckInDate(), ChronoUnit.DAYS);
            }
        }
        return res;
    }

    public List<AdditionalService> getListAdditionalServices() {
        return additionalServiceService.getListAdditionalServices();
    }

    public Room getRoomByNum(Integer roomNumber) {
        return roomService.getRoomByNum(roomNumber);
    }

    public void deleteBookingOrderByID(Integer orderID) {
        bookingOrderService.deleteBookingOrderByID(orderID);
    }

    public void deserializeListAddServ(List<AdditionalService> list) {
        additionalServiceService.deserializeListAddServ(list);
    }

    public void deserializeListBookingOrder(List<BookingOrder> list) {
        bookingOrderService.deserializeListBookingOrder(list);
    }

    public void deserializeListGuest(List<Guest> list) {
        guestService.deserializeListGuest(list);
    }

    public void deserializeListRoom(List<Room> list) {
        roomService.deserializeListRoom(list);
    }
}
