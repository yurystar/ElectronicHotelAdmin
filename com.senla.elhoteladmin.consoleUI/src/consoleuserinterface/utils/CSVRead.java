package consoleuserinterface.utils;

import com.senla.elhoteladmin.dao.RoomDaoImpl;
import com.senla.elhoteladmin.entity.Room;
import com.senla.elhoteladmin.entity.RoomStatus;
import com.senla.elhoteladmin.entity.RoomType;

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
            List<Room> roomArrayList = new ArrayList<>();
            while ((line = reader.readLine()) != null) {

                lineArray = line.split(",");
                Room room = new Room();
                room.setRoomID(Integer.parseInt(lineArray[0]));
                room.setRoomNumber(Integer.parseInt(lineArray[1]));
                room.setRoomType(RoomType.valueOf(lineArray[2]));
                room.setRoomPlaces(Integer.parseInt(lineArray[3]));
                room.setRoomPrice(Integer.parseInt(lineArray[4]));
                room.setRoomStatus(RoomStatus.valueOf(lineArray[5]));
                roomArrayList.add(room);
            }

            System.out.println(roomArrayList);
            System.out.println();
            for (Room room : roomArrayList) {
                Room roomPresent = roomDao.getRoomByNum(room.getRoomNumber());
                if (roomPresent == null) {
                    roomDao.save(room);
                } else if (!room.equals(roomPresent)) {
                    roomPresent.setRoomID(room.getRoomID());
                    roomPresent.setRoomType(room.getRoomType());
                    roomPresent.setRoomPlaces(room.getRoomPlaces());
                    roomPresent.setRoomPrice(room.getRoomPrice());
                    roomPresent.setRoomStatus(room.getRoomStatus());
                    roomDao.update(room);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error read!");
        }
    }
}
