package com.senla.elhoteladmin.dao;

import com.senla.elhoteladmin.entity.Guest;

import java.util.ArrayList;
import java.util.List;

public class GuestDaoImpl implements IGuestRepo {

    private List<Guest> guests = new ArrayList<>();

    private GuestDaoImpl() {
    }

    @Override
    public Guest get(Integer guestID) throws ArrayIndexOutOfBoundsException {
        return guests.stream()
                .filter(guest -> guest.getGuestID().equals(guestID))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Guest> getAll() {
        return guests;
    }

    @Override
    public void save(Guest guest) {
        guests.add(guest);
    }

    @Override
    public void update(Guest guest) {
        if (!guests.contains(guest)) {
            Guest tmpGuest = get(guest.getGuestID());
            if (tmpGuest != null) {
                guests.remove(tmpGuest);
                guests.add(guest);
            }
        } else {
            System.out.println("Such an object already exists!");
        }
    }

    @Override
    public void delete(Guest guest) {
        guests.remove(guest);
    }

    @Override
    public Integer getNumberOfGuests() {
        return guests.size();
    }

    @Override
    public void deserializeListGuest(List<Guest> list) {
        guests = new ArrayList<>(list);
    }
}
