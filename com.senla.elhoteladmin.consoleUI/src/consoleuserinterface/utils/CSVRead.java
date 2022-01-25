package consoleuserinterface.utils;

import com.senla.elhoteladmin.dao.AdditionalServiceDaoImpl;
import com.senla.elhoteladmin.dao.GuestDaoImpl;
import com.senla.elhoteladmin.dao.RoomDaoImpl;
import com.senla.elhoteladmin.entity.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVRead {

    public static void CSVReadRoom() {
        RoomDaoImpl roomDao = RoomDaoImpl.getInstance();
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
                    roomDao.save(roomFromImport);
                } else if (!roomFromImport.equals(roomFromStorage)) {
                    roomDao.update(roomFromImport);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error read!");
        }
    }

    public static void CSVReadGuest() {
        GuestDaoImpl guestDao = GuestDaoImpl.getInstance();
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
                Guest guestFromStorage = guestDao.get(guestFromImport.getGuestID());
                if (guestFromStorage == null) {
                    guestDao.save(guestFromImport);
                } else if (!guestFromImport.equals(guestFromStorage)) {
                    guestDao.update(guestFromImport);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error read!");
        }
    }

    public static void CSVReadAddServ() {
        AdditionalServiceDaoImpl serviceDao = AdditionalServiceDaoImpl.getInstance();
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
                AdditionalService addServFromStorage = serviceDao.get(addServFromImport.getServiceID());
                if (addServFromStorage == null) {
                    serviceDao.save(addServFromImport);
                } else if (!addServFromImport.equals(addServFromStorage)) {
                    serviceDao.update(addServFromImport);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error read!");
        }
    }
}
