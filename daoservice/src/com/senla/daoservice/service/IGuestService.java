package com.senla.daoservice.service;

import com.senla.daoservice.entity.Guest;

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
