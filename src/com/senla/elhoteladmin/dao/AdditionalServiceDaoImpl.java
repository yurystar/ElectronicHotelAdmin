package com.senla.elhoteladmin.dao;

import com.senla.elhoteladmin.entity.AdditionalService;
import com.senla.elhoteladmin.entity.Room;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AdditionalServiceDaoImpl implements IAdditionalServiceRepo {

    private List<AdditionalService> additionalServices = new ArrayList<>();

    private AdditionalServiceDaoImpl() {
    }

    @Override
    public AdditionalService get(Integer additionalServiceID) {
        return additionalServices.stream()
                .filter(addServ -> addServ.getServiceID().equals(additionalServiceID))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<AdditionalService> getAll() {
        return additionalServices;
    }

    @Override
    public void save(AdditionalService additionalService) {
        additionalServices.add(additionalService);
    }

    @Override
    public void update(AdditionalService additionalService) {
        if (!additionalServices.contains(additionalService)) {
            AdditionalService tmpAdditionalService = get(additionalService.getServiceID());
            if (tmpAdditionalService != null) {
                additionalServices.remove(tmpAdditionalService);
                additionalServices.add(additionalService);
            }
        } else {
            System.out.println("Such an object already exists!");
        }
    }

    @Override
    public void delete(AdditionalService additionalService) {
        additionalServices.remove(additionalService);
    }

    @Override
    public List<AdditionalService> getListAdditionalServicesSortedByPrice() {
        return additionalServices.stream()
                .sorted(Comparator.comparingInt(AdditionalService::getServicePrice))
                .collect(Collectors.toList());
    }

    @Override
    public void deserializeListAddServ(List<AdditionalService> list) {
        additionalServices = new ArrayList<>(list);
    }
}
