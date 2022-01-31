package com.senla.elhoteladmin.service;

import com.senla.elhoteladmin.entity.Guest;

import java.util.List;

public interface IGuestService {

    List<Guest> getGuestsHotel();

    long getNumberGuestsHotel();

    void saveGuestInStorage(Guest guest);

    void removeGuestFromStorage(Guest guest);

    Guest getGuestById(Integer guestID);

    void updateGuest(Guest guest);

    void deserializeListGuest(List<Guest> list);
}
