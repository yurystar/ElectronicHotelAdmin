package consoleuserinterface.utils;

import com.senla.elhoteladmin.dao.RoomDaoImpl;
import com.senla.elhoteladmin.entity.Room;

import java.io.*;
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
                if (roomDao.getRoomByNum(index) != null) {
                    roomsForExport.add(roomDao.getRoomByNum(index));
                } else System.out.println("Нет такой комнаты или выбор завершен.");
            }
            System.out.println("Комнаты " + roomsForExport + "\n записаны в файл.");
            System.out.println();
            for (Room room : roomsForExport) {
                String roomStr = room.getRoomID() + "," + room.getRoomNumber() + "," + room.getRoomType() + "," +
                        room.getRoomPlaces() + "," + room.getRoomPrice() + "," + room.getRoomStatus() + "\n";
                writer.write(roomStr);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error. Не удалось записать в файл.");
        }
    }
}

