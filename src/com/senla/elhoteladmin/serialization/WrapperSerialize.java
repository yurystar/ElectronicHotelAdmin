package com.senla.elhoteladmin.serialization;

import com.senla.elhoteladmin.dao.AdditionalServiceDaoImpl;
import com.senla.elhoteladmin.dao.BookingOrderDaoImpl;
import com.senla.elhoteladmin.dao.GuestDaoImpl;
import com.senla.elhoteladmin.dao.RoomDaoImpl;
import com.senla.elhoteladmin.service.AdditionalServiceService;
import com.senla.elhoteladmin.service.BookingOrderService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class WrapperSerialize {

    public static void serialize() {
        String fileName = ".." + File.separator + "allEntity.ser";
        File file = new File(fileName);
        Wrapper wrapper = new Wrapper(
                AdditionalServiceService.getInstance().getListAdditionalServices(),
                BookingOrderService.getInstance().getListBookingOrders(),
                GuestDaoImpl.getInstance().getAll(),
                RoomDaoImpl.getInstance().getAll()
        );

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream
                (new FileOutputStream(file))) {
            objectOutputStream.writeObject(wrapper);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error");
        }
        System.out.println("Данные сохранены.");
    }
}
