package com.senla.daoservice.dao;

import com.senla.daoservice.entity.AdditionalService;
import com.senla.daoservice.entity.BookingOrder;

import java.util.List;

public interface IBookingOrderRepo extends DAO<BookingOrder> {
    List<BookingOrder> getLastThreeGuestsRoom(Integer roomNumber);

    List<BookingOrder> getListGuestsAndTheirRoomsSortedByRoom();

    List<BookingOrder> getListGuestsAndTheirRoomsSortedByCheckOutDays();

    List<AdditionalService> getListAdditionalServiceOfGuestSortedByPrice(Integer guestID);

    void deserializeListBookingOrder(List<BookingOrder> list);
}
