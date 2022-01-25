package com.senla.elhoteladmin.dao;

import com.senla.elhoteladmin.entity.AdditionalService;

import java.util.List;

public interface IAdditionalServiceRepo extends DAO<AdditionalService> {
    List<AdditionalService> getListAdditionalServicesSortedByPrice();

    void deserializeListAddServ(List<AdditionalService> list);
}
