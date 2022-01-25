package consoleuserinterface.userservice;

import consoleuserinterface.actions.*;
import consoleuserinterface.actions.exportimportactions.ExportRoom;
import consoleuserinterface.actions.exportimportactions.ImportRoom;

public class Builder {
    private Menu rootMenu;

    public Menu getRootMenu() {
        this.buildRootMenu();
        return rootMenu;
    }


    private void buildRootMenu() {
        rootMenu = new Menu("Root menu");

        rootMenu.addMenuItem(new MenuItem
                ("Выход из программы                 (выберите -1)",
                        () -> System.out.println("Next"), rootMenu));
        rootMenu.addMenuItem(new MenuItem
                ("Создать заказ, поселить, выселить  (выберите 1)",
                        () -> System.out.println("Next"), getOrderMenu()));
        rootMenu.addMenuItem(new MenuItem
                ("Просмотреть информацию о гостинице (выберите 2)",
                        () -> System.out.println("Next"), getViewMenu()));
        rootMenu.addMenuItem(new MenuItem
                ("Администрирование гостиницы        (выберите 3)",
                        () -> System.out.println("Next"), getAdminChangeMenu()));
        rootMenu.addMenuItem(new MenuItem
                ("Экспорт/импорт файлов              (выберите 4)",
                        () -> System.out.println("Next"), getExpImpFilesMenu()));
    }

    public Menu getOrderMenu() {
        Menu orderMenu = new Menu("Order Menu");

        orderMenu.addMenuItem(new MenuItem
                ("Вернуться в главное меню                   (выберите 0)",
                        () -> System.out.println("Next"), rootMenu));
        orderMenu.addMenuItem(new MenuItem
                ("Оформить заказ                             (выберите 1)",
                        new CreateBookingOrder(), orderMenu));
        orderMenu.addMenuItem(new MenuItem
                ("Рассчитать стоимость проживания по заказу  (выберите 2)",
                        new GetOrderPrice(), orderMenu));
        orderMenu.addMenuItem(new MenuItem
                ("Поселить в номер                           (выберите 3)",
                        new CheckInOrder(), orderMenu));
        orderMenu.addMenuItem(new MenuItem
                ("Выселить из номера                         (выберите 4)",
                        new CheckOutOrder(), orderMenu));
        orderMenu.addMenuItem(new MenuItem
                ("Удалить заказ                              (выберите 5)",
                        new DeleteBookingOrder(), orderMenu));

        return orderMenu;
    }

    public Menu getViewMenu() {
        Menu viewMenu = new Menu("View Menu");

        viewMenu.addMenuItem(new MenuItem
                ("Вернуться в главное меню  (выберите 0)",
                        () -> System.out.println("Next"), rootMenu));
        viewMenu.addMenuItem(new MenuItem
                ("Номера                    (выберите 1)",
                        () -> System.out.println("Next"), getRoomViewMenu()));
        viewMenu.addMenuItem(new MenuItem
                ("Гости                     (выберите 2)",
                        () -> System.out.println("Next"), getGuestViewMenu()));
        viewMenu.addMenuItem(new MenuItem
                ("Заказы                    (выберите 3)",
                        () -> System.out.println("Next"), getOrderViewMenu()));
        viewMenu.addMenuItem(new MenuItem
                ("Дополнительные услуги     (выберите 4)",
                        () -> System.out.println("Next"), getAddServiceViewMenu()));

        return viewMenu;
    }

    public Menu getRoomViewMenu() {
        Menu roomViewMenu = new Menu("Room view Menu");

        roomViewMenu.addMenuItem(new MenuItem
                ("Вернуться в главное меню                    (выберите 0)",
                        () -> System.out.println("Next"), rootMenu));
        roomViewMenu.addMenuItem(new MenuItem
                ("Список номеров с сортировкой                (выберите 1)",
                        new ShowSortedRooms(), roomViewMenu));
        roomViewMenu.addMenuItem(new MenuItem
                ("Количество свободных номеров                (выберите 2)",
                        new ShowNumberEmptyHotelRooms(), roomViewMenu));
        roomViewMenu.addMenuItem(new MenuItem
                ("Список свободных номеров по дате в будущем  (выберите 3)",
                        new ShowEmptyHotelRoomsListOnDate(), roomViewMenu));
        roomViewMenu.addMenuItem(new MenuItem
                ("Посмотреть список 3-х последних  \n" +
                        "постояльцев номера и даты их пребывания     (выберите 4)",
                        new ShowLastThreeGuestsRoom(), roomViewMenu));
        roomViewMenu.addMenuItem(new MenuItem
                ("Спецификация номера                         (выберите 5)",
                        new ShowRoomDetails(), roomViewMenu));

        return roomViewMenu;
    }

    public Menu getGuestViewMenu() {
        Menu guestViewMenu = new Menu("Guest View Menu");

        guestViewMenu.addMenuItem(new MenuItem
                ("Вернуться в главное меню                     (выберите 0)",
                        () -> System.out.println("Next"), rootMenu));
        guestViewMenu.addMenuItem(new MenuItem
                ("Список гостей                                (выберите 1)",
                        new ShowGuestsHotel(), guestViewMenu));
        guestViewMenu.addMenuItem(new MenuItem
                ("Список гостей и их номеров, \n" +
                        "сортированный по комнате                     (выберите 2)",
                        new ShowListGuestsAndTheirRoomsSortedByRoom(), guestViewMenu));
        guestViewMenu.addMenuItem(new MenuItem
                ("Список гостей и их номеров, \n" +
                        "сортированный по дате освобождения номера    (выберите 3)",
                        new ShowListGuestsAndTheirRoomsSortedByCheckOutDays(), guestViewMenu));
        guestViewMenu.addMenuItem(new MenuItem
                ("Общее количество гостей отеля                (выберите 4)",
                        new GetNumberGuestsHotel(), guestViewMenu));
        guestViewMenu.addMenuItem(new MenuItem
                ("Список услуг гостя                           (выберите 5)",
                        new ShowListAdditionalServiceOfGuestSortedByPrice(), guestViewMenu));

        return guestViewMenu;
    }

    public Menu getOrderViewMenu() {
        Menu orderViewMenu = new Menu("Order View Menu");

        orderViewMenu.addMenuItem(new MenuItem
                ("Вернуться в главное меню        (выберите 0)",
                        () -> System.out.println("Next"), rootMenu));
        orderViewMenu.addMenuItem(new MenuItem
                ("Список всех заказов             (выберите 1)",
                        new ShowListBookingOrders(), orderViewMenu));

        return orderViewMenu;
    }

    public Menu getAddServiceViewMenu() {
        Menu addServiceViewMenu = new Menu("AddService View Menu");

        addServiceViewMenu.addMenuItem(new MenuItem
                ("Вернуться в главное меню                        (выберите 0)",
                        () -> System.out.println("Next"), rootMenu));
        addServiceViewMenu.addMenuItem(new MenuItem
                ("Список всех дополнительных сервисов и их цены   (выберите 1)",
                        new ShowListAdditionalServices(), addServiceViewMenu));

        return addServiceViewMenu;
    }

    public Menu getAdminChangeMenu() {
        Menu adminChangeMenu = new Menu("Admin Change Menu");

        adminChangeMenu.addMenuItem(new MenuItem
                ("Вернуться в главное меню                (выберите 0)",
                        () -> System.out.println("Next"), rootMenu));
        adminChangeMenu.addMenuItem(new MenuItem
                ("Добавить комнату                        (выберите 1)",
                        new CreateNewRoom(), adminChangeMenu));
        adminChangeMenu.addMenuItem(new MenuItem
                ("Удалить комнату                         (выберите 2)",
                        new DeleteRoom(), adminChangeMenu));
        adminChangeMenu.addMenuItem(new MenuItem
                ("Добавить дополнительный сервис          (выберите 3)",
                        new CreateNewAdditionalService(), adminChangeMenu));
        adminChangeMenu.addMenuItem(new MenuItem
                ("Удалить дополнительный сервис           (выберите 4)",
                        new DeleteAdditionalService(), adminChangeMenu));
        adminChangeMenu.addMenuItem(new MenuItem
                ("Изменить цену номера                    (выберите 5)",
                        new SetNewPriceRoom(), adminChangeMenu));
        adminChangeMenu.addMenuItem(new MenuItem
                ("Установить номеру статус \"На ремонте\"   (выберите 6)",
                        new SetRoomStatusAsOnRepair(), adminChangeMenu));
        adminChangeMenu.addMenuItem(new MenuItem
                ("Установить номеру статус \"Свободен\"     (выберите 7)",
                        new SetRoomStatusAsEmpty(), adminChangeMenu));

        return adminChangeMenu;
    }

    public Menu getExpImpFilesMenu() {
        Menu expImpFilesMenu = new Menu("Exp/Imp Files Menu");

        expImpFilesMenu.addMenuItem(new MenuItem
                ("Вернуться в главное меню                (выберите 0)",
                        () -> System.out.println("Next"), rootMenu));
        expImpFilesMenu.addMenuItem(new MenuItem
                ("Экспортировать файл с комнатой(ами)     (выберите 1)",
                        new ExportRoom(), expImpFilesMenu));
        expImpFilesMenu.addMenuItem(new MenuItem
                ("Импортировать файл с комнатой(ами)      (выберите 2)",
                        new ImportRoom(), expImpFilesMenu));
//        expImpFilesMenu.addMenuItem(new MenuItem
//                ("Добавить дополнительный сервис          (выберите 3)",
//                        new CreateNewAdditionalService(), expImpFilesMenu));
//        expImpFilesMenu.addMenuItem(new MenuItem
//                ("Удалить дополнительный сервис           (выберите 4)",
//                        new DeleteAdditionalService(), expImpFilesMenu));
//        expImpFilesMenu.addMenuItem(new MenuItem
//                ("Изменить цену номера                    (выберите 5)",
//                        new SetNewPriceRoom(), expImpFilesMenu));
//        expImpFilesMenu.addMenuItem(new MenuItem
//                ("Установить номеру статус \"На ремонте\"   (выберите 6)",
//                        new SetRoomStatusAsOnRepair(), expImpFilesMenu));
//        expImpFilesMenu.addMenuItem(new MenuItem
//                ("Установить номеру статус \"Свободен\"     (выберите 7)",
//                        new SetRoomStatusAsEmpty(), expImpFilesMenu));

        return expImpFilesMenu;
    }
}
