package com.senla.daoservice.serialization;

import com.senla.daoservice.controller.ActionController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class WrapperSerialize {
    private static WrapperSerialize instance;

    public static synchronized WrapperSerialize getInstance() {
        if (instance == null) {
            instance = new WrapperSerialize();
        }
        return instance;
    }

    public  void serialize() {
        ActionController adminController = new ActionController();
        String fileName = "resources" + File.separator + "allEntity.ser";
        File file = new File(fileName);
        Wrapper wrapper = new Wrapper(
                adminController.getAdminController().getListAdditionalServices(),
                adminController.getAdminController().getListBookingOrders(),
                adminController.getAdminController().getGuestsHotel(),
                adminController.getAdminController().getRoomsList()
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
