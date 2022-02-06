package com.senla.daoservice.service;

import com.senla.daoservice.entity.AdditionalService;

import java.util.List;

public interface IAdditionalServiceService {
    List<AdditionalService> getListAdditionalServices();

    List<AdditionalService> getListAdditionalServicesSortedByPrice();

    void saveNewAdditionalService(AdditionalService additionalService);

    void deleteAdditionalService(AdditionalService additionalService);

    AdditionalService getAdditionalServiceByID(Integer serviceID);

    public void deserializeListAddServ(List<AdditionalService> list);

    void updateAdditionalService(AdditionalService additionalService);
}
