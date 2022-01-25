package com.senla.elhoteladmin.dao;

import com.senla.elhoteladmin.entity.AdditionalService;
import com.senla.elhoteladmin.entity.BookingOrder;

import java.util.List;

public interface IBookingOrderRepo extends DAO<BookingOrder> {
    List<BookingOrder> getLastThreeGuestsRoom(Integer roomNumber);

    List<BookingOrder> getListGuestsAndTheirRoomsSortedByRoom();

    List<BookingOrder> getListGuestsAndTheirRoomsSortedByCheckOutDays();

    List<AdditionalService> getListAdditionalServiceOfGuestSortedByPrice(Integer guestID);

    void deserializeListBookingOrder(List<BookingOrder> list);
}
