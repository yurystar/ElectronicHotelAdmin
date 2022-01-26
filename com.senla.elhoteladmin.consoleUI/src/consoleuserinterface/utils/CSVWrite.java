package consoleuserinterface.utils;

import com.senla.elhoteladmin.dao.AdditionalServiceDaoImpl;
import com.senla.elhoteladmin.dao.BookingOrderDaoImpl;
import com.senla.elhoteladmin.dao.GuestDaoImpl;
import com.senla.elhoteladmin.dao.RoomDaoImpl;
import com.senla.elhoteladmin.entity.AdditionalService;
import com.senla.elhoteladmin.entity.BookingOrder;
import com.senla.elhoteladmin.entity.Guest;
import com.senla.elhoteladmin.entity.Room;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CSVWrite {

    public static void CSVWriteRoom() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("..\\Room.csv"))) {
            RoomDaoImpl roomDao = RoomDaoImpl.getInstance();
            List<Room> roomsForExport = new ArrayList<>();

            int index = -1;
            while (index != 0) {
                System.out.println("Введите номер комнаты для экспорта. Или введите 0 для завершения выбора.");
                index = ScanUtil.getInt();
                if (roomDao.getRoomByNum(index) != null && index != 0) {
                    roomsForExport.add(roomDao.getRoomByNum(index));
                } else System.out.println("Нет такой комнаты или выбор завершен.\n");
            }

            for (Room room : roomsForExport) {
                String roomStr = room.getRoomID() + "," + room.getRoomNumber() + "," + room.getRoomType() + "," +
                        room.getRoomPlaces() + "," + room.getRoomPrice() + "," + room.getRoomStatus() + "\n";
                writer.write(roomStr);
            }

            System.out.println("Комнаты " + roomsForExport + "\nзаписаны в файл.\n");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error. Не удалось записать в файл.");
        }
    }

    public static void CSVWriteGuest() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("..\\Guest.csv"))) {
            GuestDaoImpl guestDao = GuestDaoImpl.getInstance();
            List<Guest> guestsForExport = new ArrayList<>();

            int index = -1;
            while (index != 0) {
                System.out.println("Введите ID номер гостя для экспорта. Или введите 0 для завершения выбора.");
                index = ScanUtil.getInt();
                if (guestDao.get(index) != null && index != 0) {
                    guestsForExport.add(guestDao.get(index));
                } else System.out.println("Нет такого гостя или выбор завершен.\n");
            }

            for (Guest guest : guestsForExport) {
                String guestStr = guest.getGuestID() + "," + guest.getGuestPassport() + "," +
                        guest.getGuestName() + "," + guest.getGuestSurname() + "\n";
                writer.write(guestStr);
            }

            System.out.println("Комнаты " + guestsForExport + "\nзаписаны в файл.\n");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error. Не удалось записать в файл.");
        }
    }

    public static void CSVWriteAddServ() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("..\\AdditionalService.csv"))) {
            AdditionalServiceDaoImpl serviceDao = AdditionalServiceDaoImpl.getInstance();
            List<AdditionalService> servicesForExport = new ArrayList<>();

            int index = -1;
            while (index != 0) {
                System.out.println("Введите ID номер дополнительного сервиса для экспорта. " +
                        "Или введите 0 для завершения выбора.");
                index = ScanUtil.getInt();
                if (serviceDao.get(index) != null && index != 0) {
                    servicesForExport.add(serviceDao.get(index));
                } else System.out.println("Нет такого дополнительного сервиса или выбор завершен.\n");
            }

            for (AdditionalService service : servicesForExport) {
                String serviceStr = service.getServiceID() + "," + service.getServiceName() + "," +
                        service.getServicePrice() + "\n";
                writer.write(serviceStr);
            }

            System.out.println("Дополнительные сервисы " + servicesForExport + "\nзаписаны в файл.\n");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error. Не удалось записать в файл.");
        }
    }

    public static void CSVWriteBookOrder() {
        String roomStr;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("..\\BookingOrder.csv"))) {
            BookingOrderDaoImpl bookingOrderDao = BookingOrderDaoImpl.getInstance();
            List<BookingOrder> orders = new ArrayList<>();

            int index = -1;
            while (index != 0) {
                System.out.println("Введите номер заказа для экспорта. Или введите 0 для завершения выбора.");
                index = ScanUtil.getInt();
                if (bookingOrderDao.get(index) != null && index != 0) {
                    orders.add(bookingOrderDao.get(index));
                } else System.out.println("Нет такого заказа или выбор завершен.\n");
            }

            for (BookingOrder bookingOrder : orders) {
                roomStr = bookingOrder.getOrderID() + "|" +
                        formatter.format(bookingOrder.getOrderCreateDate()) + "|" +
                        formatter.format(bookingOrder.getOrderCheckInDate()) + "|" +
                        formatter.format(bookingOrder.getOrderCheckOutDate()) + "|" +
                        bookingOrder.getOrderedHotelRoom().getRoomID() + "," +
                        bookingOrder.getOrderedHotelRoom().getRoomNumber() + "," +
                        bookingOrder.getOrderedHotelRoom().getRoomType() + "," +
                        bookingOrder.getOrderedHotelRoom().getRoomPlaces() + "," +
                        bookingOrder.getOrderedHotelRoom().getRoomPrice() + "," +
                        bookingOrder.getOrderedHotelRoom().getRoomStatus() + "|";
                for (AdditionalService service : bookingOrder.getOrderedAdditionalServices()) {
                    roomStr += service.getServiceID() + "," +
                            service.getServiceName() + "," +
                            service.getServicePrice() + "-";
                }
                roomStr = roomStr.substring(0, roomStr.length() - 1) + "|";

                for (Guest guest : bookingOrder.getOrderHotelGuests()) {
                    roomStr += guest.getGuestID() + "," +
                            guest.getGuestPassport() + "," +
                            guest.getGuestName() + "," +
                            guest.getGuestSurname() + "-";
                }
                roomStr = roomStr.substring(0, roomStr.length() - 1) + "|";
                roomStr += bookingOrder.getOrderStatus() + "\n";

                writer.write(roomStr);
            }

            System.out.println("Заказы " + orders + "\nзаписаны в файл.\n");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error. Не удалось записать в файл.");
        }
    }
}
