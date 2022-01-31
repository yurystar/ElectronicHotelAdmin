package com.senla.elhoteladmin.service;

import com.senla.elhoteladmin.dao.IBookingOrderRepo;
import com.senla.elhoteladmin.entity.AdditionalService;
import com.senla.elhoteladmin.entity.BookingOrder;
import depinject.DepInjReflectUtil;
import depinject.DependencyInjection;

import java.util.List;

public class BookingOrderService implements IBookingOrderService {
    @DependencyInjection
    private IBookingOrderRepo bookingOrderRepo;

    private static BookingOrderService instance;

    public static synchronized BookingOrderService getInstance() {
        if (instance == null) {
            instance = new BookingOrderService();
        }
        return instance;
    }

    private BookingOrderService() {
        DepInjReflectUtil.initializeDepInjection(this);
    }

    @Override
    public List<BookingOrder> getLastThreeGuestsRoom(Integer roomNumber) {
        return bookingOrderRepo.getLastThreeGuestsRoom(roomNumber);
    }

    @Override
    public List<BookingOrder> getListBookingOrders() {
        return bookingOrderRepo.getAll();
    }

    @Override
    public List<BookingOrder> getListGuestsAndTheirRoomsSortedByRoom() {
        return bookingOrderRepo.getListGuestsAndTheirRoomsSortedByRoom();
    }

    @Override
    public List<BookingOrder> getListGuestsAndTheirRoomsSortedByCheckOutDays() {
        return bookingOrderRepo.getListGuestsAndTheirRoomsSortedByCheckOutDays();
    }

    @Override
    public void saveNewBookingOrder(BookingOrder order) {
        bookingOrderRepo.save(order);
    }

    @Override
    public List<AdditionalService> getListAdditionalServiceOfGuestSortedByPrice(Integer guestID) {
        return bookingOrderRepo.getListAdditionalServiceOfGuestSortedByPrice(guestID);
    }

    @Override
    public void deleteBookingOrderByID(Integer orderID) {
        BookingOrder order = bookingOrderRepo.get(orderID);
        if (order != null) {
            bookingOrderRepo.delete(order);
        }
    }

    @Override
    public BookingOrder getBookingOrderByID(Integer bookingOrderID) {
        return bookingOrderRepo.get(bookingOrderID);
    }

    @Override
    public void updateBookingOrder(BookingOrder bookingOrder) {
        bookingOrderRepo.update(bookingOrder);
    }

    @Override
    public void deserializeListBookingOrder(List<BookingOrder> list) {
        bookingOrderRepo.deserializeListBookingOrder(list);
    }
}
