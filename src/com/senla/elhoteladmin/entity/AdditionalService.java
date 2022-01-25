package com.senla.elhoteladmin.entity;

import java.io.Serializable;
import java.util.Objects;

public class AdditionalService implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer serviceID;
    private String serviceName;
    private Integer servicePrice;

    public AdditionalService() {
    }

    public AdditionalService(Integer serviceID, String serviceName, Integer servicePrice) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.servicePrice = servicePrice;
    }

    public Integer getServiceID() {
        return serviceID;
    }

    public void setServiceID(Integer serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(Integer servicePrice) {
        this.servicePrice = servicePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdditionalService)) return false;
        AdditionalService that = (AdditionalService) o;
        return getServiceID().equals(that.getServiceID()) && getServiceName().equals(that.getServiceName()) && getServicePrice().equals(that.getServicePrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getServiceID(), getServiceName(), getServicePrice());
    }

    @Override
    public String toString() {
        return "\nAdditionalService{" +
                "serviceID=" + serviceID +
                ", serviceName='" + serviceName + '\'' +
                ", servicePrice=" + servicePrice +
                '}';
    }
}
