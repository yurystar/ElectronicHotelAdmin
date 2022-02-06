package com.senla.daoservice.controller;

import com.senla.daoservice.entity.*;
import com.senla.daoservice.service.*;
import depinject.DepInjReflectUtil;
import depinject.DependencyInjection;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class AdminController implements IAdminController {
    @DependencyInjection
    private IAdditionalServiceService additionalServiceService;

    @DependencyInjection
    private IBookingOrderService bookingOrderService;

    @DependencyInjection
    private IGuestService guestService;

    @DependencyInjection
    private IRoomService roomService;

    public AdminController() {
        DepInjReflectUtil.initializeDepInjection(this);
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
        List<Room> EmptyHotelRoomsListOnDate = new ArrayList<>(roomService.getRoomsList());
        EmptyHotelRoomsListOnDate.removeAll(roomsBusy);
        return EmptyHotelRoomsListOnDate;
    }

    public void checkInOrder(Integer orderID) {
        for (BookingOrder order : bookingOrderService.getListBookingOrders()) {
            if (order.getOrderID().equals(orderID)) {
                order.setOrderStatus(OrderStatus.CHECK_IN);
                for (Guest guest : order.getOrderHotelGuests()) {
                    guestService.saveGuestInStorage(guest);
                }
                for (Room room : roomService.getRoomsList()) {
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
                for (Room room : roomService.getRoomsList()) {
                    if (room.getRoomNumber().equals(order.getOrderedHotelRoom().getRoomNumber())) {
                        room.setRoomStatus(RoomStatus.EMPTY);
                    }
                }
//                }
            }
        }
    }

    public void setRoomStatusAsOnRepair(Integer roomNumber) {
        if (roomService.getRoomStatusChange()) {
            for (Room rooms : roomService.getRoomsList()) {
                if (rooms.getRoomNumber().equals(roomNumber)
                        && !rooms.getRoomStatus().equals(RoomStatus.ON_REPAIR)
                        && !rooms.getRoomStatus().equals(RoomStatus.BUSY)) {
                    rooms.setRoomStatus(RoomStatus.ON_REPAIR);
                    System.out.println("Статус изменен.\n");
                }
            }
        } else System.out.println("Изменение статуса номера запрещено.");
    }

    public void setRoomStatusAsEmpty(Integer roomNumber) {
        for (Room rooms : roomService.getRoomsList()) {
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

    @Override
    public List<AdditionalService> getListAdditionalServicesSortedByPrice() {
        return additionalServiceService.getListAdditionalServicesSortedByPrice();
    }

    @Override
    public void saveNewAdditionalService(AdditionalService additionalService) {
        additionalServiceService.saveNewAdditionalService(additionalService);
    }

    @Override
    public void deleteAdditionalService(AdditionalService additionalService) {
        additionalServiceService.deleteAdditionalService(additionalService);
    }

    @Override
    public void updateAdditionalService(AdditionalService additionalService) {
        additionalServiceService.updateAdditionalService(additionalService);
    }

    @Override
    public List<BookingOrder> getLastThreeGuestsRoom(Integer roomNumber) {
        return bookingOrderService.getLastThreeGuestsRoom(roomNumber);
    }

    @Override
    public List<BookingOrder> getListBookingOrders() {
        return bookingOrderService.getListBookingOrders();
    }

    @Override
    public List<AdditionalService> getListAdditionalServiceOfGuestSortedByPrice(Integer guestID) {
        return bookingOrderService.getListAdditionalServiceOfGuestSortedByPrice(guestID);
    }

    @Override
    public BookingOrder getBookingOrderByID(Integer bookingOrderID) {
        return bookingOrderService.getBookingOrderByID(bookingOrderID);
    }

    @Override
    public void updateBookingOrder(BookingOrder bookingOrder) {
        bookingOrderService.updateBookingOrder(bookingOrder);
    }

    @Override
    public List<Guest> getGuestsHotel() {
        return guestService.getGuestsHotel();
    }

    @Override
    public long getNumberGuestsHotel() {
        return guestService.getNumberGuestsHotel();
    }

    @Override
    public void saveGuestInStorage(Guest guest) {
        guestService.saveGuestInStorage(guest);
    }

    @Override
    public void removeGuestFromStorage(Guest guest) {
        guestService.removeGuestFromStorage(guest);
    }

    @Override
    public Guest getGuestById(Integer guestID) {
        return guestService.getGuestById(guestID);
    }

    @Override
    public void updateGuest(Guest guest) {
        guestService.updateGuest(guest);
    }

    @Override
    public List<Room> getHotelRoomsSortedByRoomPlaces() {
        return roomService.getHotelRoomsSortedByRoomPlaces();
    }

    @Override
    public List<Room> getHotelRoomsSortedByRoomPrice() {
        return roomService.getHotelRoomsSortedByRoomPrice();
    }

    @Override
    public List<Room> getHotelRoomsSortedByRoomType() {
        return roomService.getHotelRoomsSortedByRoomType();
    }

    @Override
    public List<Room> getEmptyHotelRoomsSortedByRoomPlaces() {
        return roomService.getEmptyHotelRoomsSortedByRoomPlaces();
    }

    @Override
    public List<Room> getEmptyHotelRoomsSortedByRoomPrice() {
        return roomService.getEmptyHotelRoomsSortedByRoomPrice();
    }

    @Override
    public List<Room> getEmptyHotelRoomsSortedByRoomType() {
        return roomService.getEmptyHotelRoomsSortedByRoomType();
    }

    @Override
    public long getNumberEmptyHotelRooms() {
        return roomService.getNumberEmptyHotelRooms();
    }

    @Override
    public void saveNewRoom(Room room) {
        roomService.saveNewRoom(room);
    }

    @Override
    public void deleteRoom(Room room) {
        roomService.deleteRoom(room);
    }

    @Override
    public List<Room> getRoomsList() {
        return roomService.getRoomsList();
    }

    @Override
    public void setNewPriceRoom(Integer roomNumber, Integer priceRoom) {
        roomService.setNewPriceRoom(roomNumber, priceRoom);
    }

    @Override
    public void updateRoom(Room room) {
        roomService.updateRoom(room);
    }

    @Override
    public Boolean getRoomStatusChange() {
        return roomService.getRoomStatusChange();
    }
}
