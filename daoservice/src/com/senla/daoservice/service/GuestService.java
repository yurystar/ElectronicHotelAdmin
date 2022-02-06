package com.senla.daoservice.service;

import com.senla.daoservice.dao.IGuestRepo;
import com.senla.daoservice.entity.Guest;
import depinject.DepInjReflectUtil;
import depinject.DependencyInjection;

import java.util.List;

public class GuestService implements IGuestService {
    @DependencyInjection
    private IGuestRepo guestRepo;

    public GuestService() {
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
