package consoleuserinterface.utils;

import com.senla.elhoteladmin.entity.*;
import com.senla.elhoteladmin.service.AdditionalServiceService;
import com.senla.elhoteladmin.service.BookingOrderService;
import com.senla.elhoteladmin.service.GuestService;
import com.senla.elhoteladmin.service.RoomService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CSVRead {

    public static void CSVReadRoom() {
        RoomService roomDao = RoomService.getInstance();
        try (BufferedReader reader = new BufferedReader(new FileReader("..\\Room.csv"))) {

            String[] lineArray;
            String line;
            List<Room> roomsFromFile = new ArrayList<>();
            while ((line = reader.readLine()) != null) {

                lineArray = line.split(",");
                Room room = new Room();
                room.setRoomID(Integer.parseInt(lineArray[0]));
                room.setRoomNumber(Integer.parseInt(lineArray[1]));
                room.setRoomType(RoomType.valueOf(lineArray[2]));
                room.setRoomPlaces(Integer.parseInt(lineArray[3]));
                room.setRoomPrice(Integer.parseInt(lineArray[4]));
                room.setRoomStatus(RoomStatus.valueOf(lineArray[5]));
                roomsFromFile.add(room);
            }

            System.out.println(roomsFromFile);
            System.out.println();

            for (Room roomFromImport : roomsFromFile) {
                Room roomFromStorage = roomDao.getRoomByNum(roomFromImport.getRoomNumber());
                if (roomFromStorage == null) {
                    roomDao.saveNewRoom(roomFromImport);
                } else if (!roomFromImport.equals(roomFromStorage)) {
                    roomDao.updateRoom(roomFromImport);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error read!");
        }
    }

    public static void CSVReadGuest() {
        GuestService guestDao = GuestService.getInstance();
        try (BufferedReader reader = new BufferedReader(new FileReader("..\\Guest.csv"))) {

            String[] lineArray;
            String line;
            List<Guest> guestsFromFile = new ArrayList<>();
            while ((line = reader.readLine()) != null) {

                lineArray = line.split(",");
                Guest guest = new Guest();
                guest.setGuestID(Integer.parseInt(lineArray[0]));
                guest.setGuestPassport(Integer.parseInt(lineArray[1]));
                guest.setGuestName(lineArray[2]);
                guest.setGuestSurname(lineArray[3]);
                guestsFromFile.add(guest);
            }

            System.out.println(guestsFromFile);
            System.out.println();

            for (Guest guestFromImport : guestsFromFile) {
                Guest guestFromStorage = guestDao.getGuestById(guestFromImport.getGuestID());
                if (guestFromStorage == null) {
                    guestDao.saveGuestInStorage(guestFromImport);
                } else if (!guestFromImport.equals(guestFromStorage)) {
                    guestDao.updateGuest(guestFromImport);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error read!");
        }
    }

    public static void CSVReadAddServ() {
        AdditionalServiceService serviceDao = AdditionalServiceService.getInstance();
        try (BufferedReader reader = new BufferedReader(new FileReader("..\\AdditionalService.csv"))) {

            String[] lineArray;
            String line;
            List<AdditionalService> addServsFromFile = new ArrayList<>();
            while ((line = reader.readLine()) != null) {

                lineArray = line.split(",");
                AdditionalService service = new AdditionalService();
                service.setServiceID(Integer.parseInt(lineArray[0]));
                service.setServiceName(lineArray[1]);
                service.setServicePrice(Integer.parseInt(lineArray[2]));
                addServsFromFile.add(service);
            }

            System.out.println(addServsFromFile);
            System.out.println();

            for (AdditionalService addServFromImport : addServsFromFile) {
                AdditionalService addServFromStorage = serviceDao.getAdditionalServiceByID(addServFromImport.getServiceID());
                if (addServFromStorage == null) {
                    serviceDao.saveNewAdditionalService(addServFromImport);
                } else if (!addServFromImport.equals(addServFromStorage)) {
                    serviceDao.updateAdditionalService(addServFromImport);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error read!");
        }
    }

    public static void CSVReadBookOrder() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        BookingOrderService bookingOrderDao = BookingOrderService.getInstance();

        try (BufferedReader reader = new BufferedReader(new FileReader("..\\BookingOrder.csv"))) {

            String[] baseLineArray;
            String[] roomLineArray;
            String[] addServLineArray;
            String[] guestLineArray;
            String line;
            List<BookingOrder> BookOrdersFromFile = new ArrayList<>();
            while ((line = reader.readLine()) != null) {

                baseLineArray = line.split("\\|");
                roomLineArray = baseLineArray[4].split(",");
                addServLineArray = baseLineArray[5].split("-");
                guestLineArray = baseLineArray[6].split("-");

                BookingOrder order = new BookingOrder();

                order.setOrderID(Integer.parseInt(baseLineArray[0]));
                order.setOrderCreateDate(LocalDate.parse(baseLineArray[1], formatter));
                order.setOrderCheckInDate(LocalDate.parse(baseLineArray[2], formatter));
                order.setOrderCheckOutDate(LocalDate.parse(baseLineArray[3], formatter));

                Room room = new Room();
                room.setRoomID(Integer.parseInt(roomLineArray[0]));
                room.setRoomNumber(Integer.parseInt(roomLineArray[1]));
                room.setRoomType(RoomType.valueOf(roomLineArray[2]));
                room.setRoomPlaces(Integer.parseInt(roomLineArray[3]));
                room.setRoomPrice(Integer.parseInt(roomLineArray[4]));
                room.setRoomStatus(RoomStatus.valueOf(roomLineArray[5]));
                order.setOrderedHotelRoom(room);

                List<AdditionalService> additionalServices = new ArrayList<>();
                for (int i = 0; i < addServLineArray.length; i++) {
                    String[] servArray = addServLineArray[i].split(",");
                    AdditionalService service = new AdditionalService();
                    service.setServiceID(Integer.parseInt(servArray[0]));
                    service.setServiceName(servArray[1]);
                    service.setServicePrice(Integer.parseInt(servArray[2]));
                    additionalServices.add(service);
                }
                order.setOrderedAdditionalServices(additionalServices);

                List<Guest> guests = new ArrayList<>();
                for (int i = 0; i < guestLineArray.length; i++) {
                    String[] guestArray = guestLineArray[i].split(",");
                    Guest guest = new Guest();
                    guest.setGuestID(Integer.parseInt(guestArray[0]));
                    guest.setGuestPassport(Integer.parseInt(guestArray[1]));
                    guest.setGuestName(guestArray[2]);
                    guest.setGuestSurname(guestArray[3]);
                    guests.add(guest);
                }
                order.setOrderHotelGuests(guests);
                order.setOrderStatus(OrderStatus.valueOf(baseLineArray[7]));

                BookOrdersFromFile.add(order);
            }

            System.out.println(BookOrdersFromFile);
            System.out.println();

            for (BookingOrder bookOrdFromImport : BookOrdersFromFile) {
                BookingOrder bookOrdFromStorage =
                        bookingOrderDao.getBookingOrderByID(bookOrdFromImport.getOrderID());
                if (bookOrdFromStorage == null) {
                    bookingOrderDao.saveNewBookingOrder(bookOrdFromImport);
                } else if (!bookOrdFromImport.equals(bookOrdFromStorage)) {
                    bookingOrderDao.updateBookingOrder(bookOrdFromImport);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error read!");
        }
    }
}
