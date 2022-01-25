package com.senla.elhoteladmin.dao;

import com.senla.elhoteladmin.entity.AdditionalService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AdditionalServiceDaoImpl implements IAdditionalServiceRepo {
    private static AdditionalServiceDaoImpl instance;

    public static synchronized AdditionalServiceDaoImpl getInstance() {
        if (instance == null) {
            instance = new AdditionalServiceDaoImpl();
        }
        return instance;
    }

    private List<AdditionalService> additionalServices = new ArrayList<>();


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
            additionalServices.add(additionalService);
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
        AdditionalServiceDaoImpl.getInstance().additionalServices = new ArrayList<>(list);
    }
}
