package com.senla.daoservice.dao;

import com.senla.daoservice.entity.AdditionalService;

import java.util.List;

public interface IAdditionalServiceRepo extends DAO<AdditionalService> {
    List<AdditionalService> getListAdditionalServicesSortedByPrice();

    void deserializeListAddServ(List<AdditionalService> list);
}
