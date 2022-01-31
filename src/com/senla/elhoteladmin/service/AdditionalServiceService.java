package com.senla.elhoteladmin.service;

import com.senla.elhoteladmin.dao.IAdditionalServiceRepo;
import com.senla.elhoteladmin.entity.AdditionalService;
import depinject.DepInjReflectUtil;
import depinject.DependencyInjection;

import java.util.List;

public class AdditionalServiceService implements IAdditionalServiceService {

    @DependencyInjection
    private IAdditionalServiceRepo additionalServiceRepo;

    private static AdditionalServiceService instance;

    public static synchronized AdditionalServiceService getInstance() {
        if (instance == null) {
            instance = new AdditionalServiceService();
        }
        return instance;
    }

    private AdditionalServiceService() {
        DepInjReflectUtil.initializeDepInjection(this);
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
    public void saveNewAdditionalService(AdditionalService additionalService) {
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
    public void updateAdditionalService(AdditionalService additionalService) {
        additionalServiceRepo.update(additionalService);
    }

    @Override
    public void deserializeListAddServ(List<AdditionalService> list) {
        additionalServiceRepo.deserializeListAddServ(list);
    }
}
