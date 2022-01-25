package com.senla.elhoteladmin.dao;

import com.senla.elhoteladmin.entity.AdditionalService;
import com.senla.elhoteladmin.entity.Guest;

import java.util.List;

public interface IGuestRepo extends DAO<Guest> {
    Integer getNumberOfGuests();

    void deserializeListGuest(List<Guest> list);
}
