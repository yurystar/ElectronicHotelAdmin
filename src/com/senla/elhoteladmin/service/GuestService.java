package com.senla.elhoteladmin.service;

import com.senla.elhoteladmin.dao.IGuestRepo;
import com.senla.elhoteladmin.entity.Guest;
import depinject.DepInjReflectUtil;
import depinject.DependencyInjection;

import java.util.List;

public class GuestService implements IGuestService {
    @DependencyInjection
    private IGuestRepo guestRepo;

    private static GuestService instance;

    public static synchronized GuestService getInstance() {
        if (instance == null) {
            instance = new GuestService();
        }
        return instance;
    }

    private GuestService() {
        DepInjReflectUtil.initializeDepInjection(this);
    }

    @Override
    public void saveGuestInStorage(Guest guest) {
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
    public Guest getGuestById(Integer guestID) {
        return guestRepo.get(guestID);
    }

    @Override
    public void updateGuest(Guest guest) {
        guestRepo.update(guest);
    }

    @Override
    public void deserializeListGuest(List<Guest> list) {
        guestRepo.deserializeListGuest(list);
    }
}
