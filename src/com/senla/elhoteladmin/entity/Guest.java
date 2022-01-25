package com.senla.elhoteladmin.entity;

import java.io.Serializable;
import java.util.*;

public class Guest implements Serializable {
    private static final long serialVersionUID = 3L;

    private Integer guestID;
    private Integer guestPassport;
    private String guestName;
    private String guestSurname;

    public Guest() {
    }

    public Guest(Integer guestID, Integer guestPassport, String guestName, String guestSurname) {
        this.guestID = guestID;
        this.guestPassport = guestPassport;
        this.guestName = guestName;
        this.guestSurname = guestSurname;
    }

    public Integer getGuestID() {
        return guestID;
    }

    public void setGuestID(Integer guestID) {
        this.guestID = guestID;
    }

    public Integer getGuestPassport() {
        return guestPassport;
    }

    public void setGuestPassport(Integer guestPassport) {
        this.guestPassport = guestPassport;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestSurname() {
        return guestSurname;
    }

    public void setGuestSurname(String guestSurname) {
        this.guestSurname = guestSurname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Guest)) return false;
        Guest guest = (Guest) o;
        return getGuestID().equals(guest.getGuestID()) && getGuestPassport().equals(guest.getGuestPassport()) && getGuestName().equals(guest.getGuestName()) && getGuestSurname().equals(guest.getGuestSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGuestID(), getGuestPassport(), getGuestName(), getGuestSurname());
    }

    @Override
    public String toString() {
        return "\nGuest{" +
                "guestID=" + guestID +
                ", guestPassport=" + guestPassport +
                ", guestName='" + guestName + '\'' +
                ", guestSurname='" + guestSurname + '\'' +
                '}';
    }
}
