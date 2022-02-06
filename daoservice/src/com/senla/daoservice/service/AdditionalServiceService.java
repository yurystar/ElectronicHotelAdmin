package com.senla.daoservice.service;

import com.senla.daoservice.dao.IAdditionalServiceRepo;
import com.senla.daoservice.entity.AdditionalService;
import depinject.DepInjReflectUtil;
import depinject.DependencyInjection;

import java.util.List;

public class AdditionalServiceService implements IAdditionalServiceService {

    @DependencyInjection
    private IAdditionalServiceRepo additionalServiceRepo;

    public AdditionalServiceService() {
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
