package com.senla.elhoteladmin.service;

import com.senla.elhoteladmin.controller.AdminControllerSingleton;
import com.senla.elhoteladmin.dao.GuestDaoImpl;
import com.senla.elhoteladmin.dao.IGuestRepo;
import com.senla.elhoteladmin.entity.Guest;

import java.util.List;

public class GuestService implements IGuestService {
    private static GuestService instance;

    public static synchronized GuestService getInstance() {
        if (instance == null) {
            instance = new GuestService();
        }
        return instance;
    }

    private IGuestRepo guestRepo;

    public GuestService() {
        this.guestRepo = GuestDaoImpl.getInstance();
    }

    @Override
    public void addGuestInStorage(Guest guest) {
        guestRepo.save(guest);
    }

    @Override
    public void removeGuestFromStorage(Guest guest) {
        guestRepo.delete(guest);
    }

    @Override
    public List<Guest> getGuestsHotel() {
        return guestRepo.getAll();
    }

    @Override
    public long getNumberGuestsHotel() {
        return guestRepo.getNumberOfGuests();
    }

    @Override
    public void deserializeListGuest(List<Guest> list) {
        guestRepo.deserializeListGuest(list);
    }
}
