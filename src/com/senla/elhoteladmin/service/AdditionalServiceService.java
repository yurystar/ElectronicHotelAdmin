package com.senla.elhoteladmin.service;

import com.senla.elhoteladmin.dao.AdditionalServiceDaoImpl;
import com.senla.elhoteladmin.dao.IAdditionalServiceRepo;
import com.senla.elhoteladmin.entity.AdditionalService;

import java.util.List;

public class AdditionalServiceService implements IAdditionalServiceService {
    private IAdditionalServiceRepo additionalServiceRepo;

    private static AdditionalServiceService instance;

    public static synchronized AdditionalServiceService getInstance() {
        if (instance == null) {
            instance = new AdditionalServiceService();
        }
        return instance;
    }

    public AdditionalServiceService() {
        this.additionalServiceRepo = AdditionalServiceDaoImpl.getInstance();
    }

    @Override
    public List<AdditionalService> getListAdditionalServices() {
        return additionalServiceRepo.getAll();
    }

    @Override
    public List<AdditionalService> getListAdditionalServicesSortedByPrice() {
        return additionalServiceRepo.getListAdditionalServicesSortedByPrice();
    }

    @Override
    public void setNewAdditionalService(AdditionalService additionalService) {
        additionalServiceRepo.save(additionalService);
    }

    @Override
    public void deleteAdditionalService(AdditionalService additionalService) {
        additionalServiceRepo.delete(additionalService);
    }

    @Override
    public AdditionalService getAdditionalServiceByID(Integer serviceID) {
        return additionalServiceRepo.get(serviceID);
    }

    @Override
    public void deserializeListAddServ(List<AdditionalService> list) {
        additionalServiceRepo.deserializeListAddServ(list);
    }
}
