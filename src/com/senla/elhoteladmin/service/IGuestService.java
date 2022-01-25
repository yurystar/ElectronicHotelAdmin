package com.senla.elhoteladmin.service;

import com.senla.elhoteladmin.entity.Guest;

import java.util.List;

public interface IGuestService {

    List<Guest> getGuestsHotel();

    long getNumberGuestsHotel();

    void addGuestInStorage(Guest guest);

    void removeGuestFromStorage(Guest guest);

    void deserializeListGuest(List<Guest> list);
}
