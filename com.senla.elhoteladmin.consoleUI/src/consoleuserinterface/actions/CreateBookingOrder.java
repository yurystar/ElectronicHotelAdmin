package consoleuserinterface.actions;

import com.senla.daoservice.controller.ActionController;
import com.senla.daoservice.entity.*;
import consoleuserinterface.utils.ScanUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CreateBookingOrder implements IAction {
    ActionController adminController = new ActionController();

    private List<AdditionalService> createListAddServInOrder() {
        List<AdditionalService> listOrder = new ArrayList<>();
        int number = -1;
        do {
            System.out.println(adminController.getAdminController().getListAdditionalServices());
            System.out.println("Введите ID дополнительного сервиса. Или введите 0 для выхода. -  ");
            number = ScanUtil.getInt();
            if (number > 0 && number <= adminController.getAdminController().getListAdditionalServices().size()) {
                listOrder.add(adminController.getAdminController().getAdditionalServiceByID(number));
            } else if (number == 0) {
                System.out.println("Создание списка дополнительных сервисов завершено.\n");
            } else {
                System.out.println("Нет такой дополнительной услуги. Попробуйте ще раз.");
            }
        } while (number != 0);
        listOrder.forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------------");
        return listOrder;
    }

    private List<Guest> createListGuestsInOrder() {
        List<Guest> listGuestInOrder = new ArrayList<>();

        while (true) {
            System.out.println("Введите 1 для заполнения формы. Или введите 0 для выхода.");

            if (ScanUtil.getInt() == 0) {
                System.out.println("Создание списка гостей завершено.");
                return listGuestInOrder;
            } else {
                Guest guest = new Guest();
                System.out.println("Введите ID гостя: ");
                guest.setGuestID(ScanUtil.getInt());
                System.out.println("Введите номер паспорта гостя: ");
                guest.setGuestPassport(ScanUtil.getInt());
                System.out.println("Введите имя гостя: ");
                guest.setGuestName(ScanUtil.getStr());
                System.out.println("Введите фамилию гостя: ");
                guest.setGuestSurname(ScanUtil.getStr());
                listGuestInOrder.add(guest);
            }
        }
    }

    @Override
    public void execute() {
        System.out.println("Введите ID заказа.");
        Integer orderID = ScanUtil.getInt();

        System.out.println("Введите дату заселения.");
        LocalDate orderCheckInDate = ScanUtil.getDate();

        System.out.println("Введите дату выселения.");
        LocalDate orderCheckOutDate = ScanUtil.getDate();

        System.out.println("Введите номер комнаты.");
        Room orderedHotelRoom = adminController.getAdminController().getRoomByNum(ScanUtil.getInt());

        System.out.println("Введите поочередно ID дополнительных сервисов.");
        List<AdditionalService> orderedAdditionalServices = createListAddServInOrder();

        System.out.println("Введите поочередно данные гостей.");
        List<Guest> orderHotelGuests = createListGuestsInOrder();

        OrderStatus orderStatus = OrderStatus.BOOKING;

        BookingOrder order = new BookingOrder(orderID, orderCheckInDate, orderCheckOutDate, orderedHotelRoom,
                orderedAdditionalServices, orderHotelGuests, orderStatus);

        adminController.getAdminController().saveNewBookingOrder(order);
        System.out.println("Создан заказ " + orderID + ".");
        System.out.println(order);
        System.out.println("----------------------------------------------------------------------------");
    }
}
