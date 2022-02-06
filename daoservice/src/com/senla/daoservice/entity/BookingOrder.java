package com.senla.daoservice.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class BookingOrder implements Serializable {
    private static final long serialVersionUID = 2L;

    private Integer orderID;
    private LocalDate orderCreateDate;
    private LocalDate orderCheckInDate;
    private LocalDate orderCheckOutDate;
    private Room orderedHotelRoom;
    private List<AdditionalService> orderedAdditionalServices;
    private List<Guest> orderHotelGuests;
    private OrderStatus orderStatus;

    public BookingOrder() {
    }

    public BookingOrder(Integer orderID, LocalDate orderCheckInDate,
                        LocalDate orderCheckOutDate, Room orderedHotelRoom,
                        List<AdditionalService> orderedAdditionalServices, List<Guest> orderHotelGuests,
                        OrderStatus orderStatus) {
        this.orderID = orderID;
        this.orderCreateDate = LocalDate.now();
        this.orderCheckInDate = orderCheckInDate;
        this.orderCheckOutDate = orderCheckOutDate;
        this.orderedHotelRoom = orderedHotelRoom;
        this.orderedAdditionalServices = orderedAdditionalServices;
        this.orderHotelGuests = orderHotelGuests;
        this.orderStatus = orderStatus;
    }

    public BookingOrder(List<AdditionalService> orderedAdditionalServices) {
        this.orderedAdditionalServices = orderedAdditionalServices;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public LocalDate getOrderCreateDate() {
        return orderCreateDate;
    }

    public void setOrderCreateDate(LocalDate orderCreateDate) {
        this.orderCreateDate = orderCreateDate;
    }

    public LocalDate getOrderCheckInDate() {
        return orderCheckInDate;
    }

    public void setOrderCheckInDate(LocalDate orderCheckInDate) {
        this.orderCheckInDate = orderCheckInDate;
    }

    public LocalDate getOrderCheckOutDate() {
        return orderCheckOutDate;
    }

    public void setOrderCheckOutDate(LocalDate orderCheckOutDate) {
        this.orderCheckOutDate = orderCheckOutDate;
    }

    public Room getOrderedHotelRoom() {
        return orderedHotelRoom;
    }

    public void setOrderedHotelRoom(Room orderedHotelRoom) {
        this.orderedHotelRoom = orderedHotelRoom;
    }

    public List<AdditionalService> getOrderedAdditionalServices() {
        return orderedAdditionalServices;
    }

    public void setOrderedAdditionalServices(List<AdditionalService> orderedAdditionalServices) {
        this.orderedAdditionalServices = orderedAdditionalServices;
    }

    public List<Guest> getOrderHotelGuests() {
        return orderHotelGuests;
    }

    public void setOrderHotelGuests(List<Guest> orderHotelGuests) {
        this.orderHotelGuests = orderHotelGuests;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookingOrder)) return false;
        BookingOrder order = (BookingOrder) o;
        return getOrderID().equals(order.getOrderID()) && getOrderCreateDate().equals(order.getOrderCreateDate()) && getOrderCheckInDate().equals(order.getOrderCheckInDate()) && getOrderCheckOutDate().equals(order.getOrderCheckOutDate()) && getOrderedHotelRoom().equals(order.getOrderedHotelRoom()) && getOrderedAdditionalServices().equals(order.getOrderedAdditionalServices()) && getOrderHotelGuests().equals(order.getOrderHotelGuests()) && getOrderStatus() == order.getOrderStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderID(), getOrderCreateDate(), getOrderCheckInDate(), getOrderCheckOutDate(), getOrderedHotelRoom(), getOrderedAdditionalServices(), getOrderHotelGuests(), getOrderStatus());
    }

    @Override
    public String toString() {
        return "\nBookingOrder{" +
                "orderID=" + orderID +
                ", orderCreateDate=" + orderCreateDate +
                ", orderCheckInDate=" + orderCheckInDate +
                ", orderCheckOutDate=" + orderCheckOutDate +
                ", orderedHotelRoom=" + orderedHotelRoom +
                ", orderedAdditionalServices=" + orderedAdditionalServices +
                ", orderHotelGuests=" + orderHotelGuests +
                ", orderStatus=" + orderStatus +
                "}";
    }
}
