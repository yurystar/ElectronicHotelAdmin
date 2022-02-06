package com.senla.daoservice.serialization;

import com.senla.daoservice.entity.AdditionalService;
import com.senla.daoservice.entity.BookingOrder;
import com.senla.daoservice.entity.Guest;
import com.senla.daoservice.entity.Room;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Wrapper implements Serializable {
    List<AdditionalService> additionalServices;
    List<BookingOrder> bookingOrders;
    List<Guest> guests;
    List<Room> rooms;

    public Wrapper(List<AdditionalService> additionalServices, List<BookingOrder> bookingOrders,
                   List<Guest> guests, List<Room> rooms) {
        this.additionalServices = additionalServices;
        this.bookingOrders = bookingOrders;
        this.guests = guests;
        this.rooms = rooms;
    }

    public List<AdditionalService> getAdditionalServices() {
        return additionalServices;
    }

    public void setAdditionalServices(List<AdditionalService> additionalServices) {
        this.additionalServices = additionalServices;
    }

    public List<BookingOrder> getBookingOrders() {
        return bookingOrders;
    }

    public void setBookingOrders(List<BookingOrder> bookingOrders) {
        this.bookingOrders = bookingOrders;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wrapper)) return false;
        Wrapper wrapper = (Wrapper) o;
        return Objects.equals(getAdditionalServices(), wrapper.getAdditionalServices()) && Objects.equals(getBookingOrders(), wrapper.getBookingOrders()) && Objects.equals(getGuests(), wrapper.getGuests()) && Objects.equals(getRooms(), wrapper.getRooms());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAdditionalServices(), getBookingOrders(), getGuests(), getRooms());
    }

    @Override
    public String toString() {
        return "Wrapper{" +
                "additionalServices=" + additionalServices +
                ", bookingOrders=" + bookingOrders +
                ", guests=" + guests +
                ", rooms=" + rooms +
                '}';
    }
}
