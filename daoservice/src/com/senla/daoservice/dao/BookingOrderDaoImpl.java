package com.senla.daoservice.dao;

import com.senla.daoservice.configuration.ConfigProperty;
import com.senla.daoservice.configuration.ConfigUtil;
import com.senla.daoservice.entity.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class BookingOrderDaoImpl implements IBookingOrderRepo {

    private List<BookingOrder> bookingOrders = new ArrayList<>();

    @ConfigProperty
    private int limitNumGuestsForShow;

    public BookingOrderDaoImpl() {
        ConfigUtil.initializeProperties(this);
    }

    @Override
    public BookingOrder get(Integer bookingOrderID) throws ArrayIndexOutOfBoundsException {
        return bookingOrders.stream()
                .filter(bookingOrder -> bookingOrder.getOrderID().equals(bookingOrderID))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<BookingOrder> getAll() {
        return bookingOrders;
    }

    @Override
    public void save(BookingOrder bookingOrder) {
        bookingOrders.add(bookingOrder);
    }

    @Override
    public void update(BookingOrder bookingOrder) {
        if (!bookingOrders.contains(bookingOrder)) {
            BookingOrder tmpBookingOrder = get(bookingOrder.getOrderID());
            if (tmpBookingOrder != null) {
                bookingOrders.remove(tmpBookingOrder);
                bookingOrders.add(bookingOrder);
            }
        } else {
            System.out.println("Such an object already exists!");
        }
    }

    @Override
    public void delete(BookingOrder bookingOrder) {
        bookingOrders.remove(bookingOrder);
    }

    @Override
    public List<BookingOrder> getLastThreeGuestsRoom(Integer roomNumber) {
        return bookingOrders.stream()
                .filter(bookingOrder -> bookingOrder.getOrderedHotelRoom().getRoomNumber().equals(roomNumber))
                .filter(order -> order.getOrderStatus().equals(OrderStatus.CHECK_OUT))
                .filter(bookingOrder -> bookingOrder.getOrderCheckInDate().
                        isBefore(LocalDate.now().plusDays(1)))
                .sorted((o1, o2) -> o2.getOrderCheckInDate().compareTo(o1.getOrderCheckInDate()))
                .limit(limitNumGuestsForShow)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookingOrder> getListGuestsAndTheirRoomsSortedByRoom() {
        return bookingOrders.stream()
                .filter(bookingOrder -> bookingOrder.getOrderStatus().equals(OrderStatus.CHECK_IN))
                .sorted(Comparator.comparing(o -> o.getOrderedHotelRoom().getRoomNumber()))
                .collect(Collectors.toList());
    }


    @Override
    public List<BookingOrder> getListGuestsAndTheirRoomsSortedByCheckOutDays() {
        return bookingOrders.stream()
                .filter(bookingOrder -> bookingOrder.getOrderStatus().equals(OrderStatus.CHECK_IN))
                .sorted(Comparator.comparing(BookingOrder::getOrderCheckOutDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<AdditionalService> getListAdditionalServiceOfGuestSortedByPrice(Integer guestID) {
        List<AdditionalService> list = new ArrayList<>();
        for (BookingOrder order : bookingOrders) {
            for (Guest guest : order.getOrderHotelGuests()) {
                if (guest.getGuestID().equals(guestID)) {
                    list = order.getOrderedAdditionalServices().stream()
                            .sorted(Comparator.comparing(AdditionalService::getServicePrice))
                            .collect(Collectors.toList());
                }
            }
        }
        return list;
    }

    @Override
    public void deserializeListBookingOrder(List<BookingOrder> list) {
       bookingOrders = new ArrayList<>(list);
    }
}
