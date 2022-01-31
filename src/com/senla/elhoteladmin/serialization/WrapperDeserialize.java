package com.senla.elhoteladmin.serialization;

import com.senla.elhoteladmin.dao.AdditionalServiceDaoImpl;
import com.senla.elhoteladmin.dao.BookingOrderDaoImpl;
import com.senla.elhoteladmin.dao.GuestDaoImpl;
import com.senla.elhoteladmin.dao.RoomDaoImpl;
import com.senla.elhoteladmin.service.AdditionalServiceService;
import com.senla.elhoteladmin.service.BookingOrderService;
import com.senla.elhoteladmin.service.GuestService;
import com.senla.elhoteladmin.service.RoomService;

import java.io.*;

public class WrapperDeserialize {

    public static void deserialize() {

        String fileName = ".." + File.separator + "allEntity.ser";
        File file = new File(fileName);

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {

            Wrapper wrapper = (Wrapper) objectInputStream.readObject();
            AdditionalServiceService.getInstance().deserializeListAddServ(wrapper.getAdditionalServices());
            BookingOrderService.getInstance().deserializeListBookingOrder(wrapper.getBookingOrders());
            GuestService.getInstance().deserializeListGuest(wrapper.getGuests());
            RoomService.getInstance().deserializeListRoom(wrapper.getRooms());

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
