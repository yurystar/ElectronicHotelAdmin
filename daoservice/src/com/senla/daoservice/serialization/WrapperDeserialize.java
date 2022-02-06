package com.senla.daoservice.serialization;

import com.senla.daoservice.controller.ActionController;

import java.io.*;

public class WrapperDeserialize {

    private static WrapperDeserialize instance;

    public static synchronized WrapperDeserialize getInstance() {
        if (instance == null) {
            instance = new WrapperDeserialize();
        }
        return instance;
    }

    private WrapperDeserialize() {
    }

    public void deserialize() {
        ActionController adminController = new ActionController();
        String fileName = "resources" + File.separator + "allEntity.ser";
        File file = new File(fileName);

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {

            Wrapper wrapper = (Wrapper) objectInputStream.readObject();

            adminController.getAdminController().deserializeListAddServ(wrapper.getAdditionalServices());
            adminController.getAdminController().deserializeListBookingOrder(wrapper.getBookingOrders());
            adminController.getAdminController().deserializeListGuest(wrapper.getGuests());
            adminController.getAdminController().deserializeListRoom(wrapper.getRooms());

            System.out.println("Данные восстановлены.");

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IOException exception");
        } catch (ClassNotFoundException e) {
            System.out.println("class not found exception" + e);
        }
    }
}
