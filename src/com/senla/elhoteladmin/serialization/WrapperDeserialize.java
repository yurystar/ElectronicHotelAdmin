package com.senla.elhoteladmin.serialization;

import com.senla.elhoteladmin.dao.AdditionalServiceDaoImpl;
import com.senla.elhoteladmin.dao.BookingOrderDaoImpl;
import com.senla.elhoteladmin.dao.GuestDaoImpl;
import com.senla.elhoteladmin.dao.RoomDaoImpl;

import java.io.*;

public class WrapperDeserialize {

    public static void deserialize() throws NullPointerException {

        String fileName = ".." + File.separator + "allEntity.ser";
        File file = new File(fileName);

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {

            Wrapper wrapper = (Wrapper) objectInputStream.readObject();
            AdditionalServiceDaoImpl.getInstance().deserializeListAddServ(wrapper.getAdditionalServices());
            BookingOrderDaoImpl.getInstance().deserializeListBookingOrder(wrapper.getBookingOrders());
            GuestDaoImpl.getInstance().deserializeListGuest(wrapper.getGuests());
            RoomDaoImpl.getInstance().deserializeListRoom(wrapper.getRooms());

            System.out.println("Данные восстановлены.");

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IOException exception");
        } catch (ClassNotFoundException e) {
            System.out.println("class not found exception");
        }
    }
}
