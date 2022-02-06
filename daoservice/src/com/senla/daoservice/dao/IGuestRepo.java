package com.senla.daoservice.dao;

import com.senla.daoservice.entity.Guest;

import java.util.List;

public interface IGuestRepo extends DAO<Guest> {
    Integer getNumberOfGuests();

    void deserializeListGuest(List<Guest> list);
}
