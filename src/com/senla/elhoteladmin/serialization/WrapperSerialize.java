package com.senla.elhoteladmin.serialization;

import com.senla.elhoteladmin.service.AdditionalServiceService;
import com.senla.elhoteladmin.service.BookingOrderService;
import com.senla.elhoteladmin.service.GuestService;
import com.senla.elhoteladmin.service.RoomService;

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
                GuestService.getInstance().getGuestsHotel(),
                RoomService.getInstance().getRoomsList()
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
