package consoleuserinterface.actions;

import com.senla.daoservice.controller.ActionController;
import com.senla.daoservice.entity.Room;
import com.senla.daoservice.entity.RoomStatus;
import com.senla.daoservice.entity.RoomType;
import consoleuserinterface.utils.ScanUtil;

public class CreateNewRoom implements IAction {
    ActionController adminController = new ActionController();

    public RoomType selectRoomType() {
        System.out.println("Выберите из списка тип комнаты - \n" +
                RoomType.STARS_2 + " - Введите 1 \n" +
                RoomType.STARS_3 + " - Введите 2 \n" +
                RoomType.STARS_4 + " - Введите 3 \n" +
                "Введите 0 для выхода.");
        RoomType roomType = null;
        int number = -1;
        do {
            number = ScanUtil.getInt();
            if (number > 0 && number < 4) {
                if (number == 1) {
                    roomType = RoomType.STARS_2;
                } else if (number == 2) {
                    roomType = RoomType.STARS_3;
                } else {
                    roomType = RoomType.STARS_4;
                }
            } else if (number == 0) {
                System.out.println("Выбор завершен.\n");
            } else System.out.println("Нет такого варианта выбора. Попробуйте еще раз.\n");
        } while (number != 0);
        return roomType;
    }

    @Override
    public void execute() {
        Room room = new Room();

        System.out.println("Введите ID комнаты - ");
        room.setRoomID(ScanUtil.getInt());

        System.out.println("Введите номер комнаты - ");
        Integer roomNum = ScanUtil.getInt();
        if (adminController.getAdminController().getRoomByNum(roomNum) != null) {
            System.out.println("Комната с таким номером уже существует.\n");
            return;
        } else room.setRoomNumber(roomNum);

        System.out.println("Выберите тип комнаты - ");
        room.setRoomType(selectRoomType());

        System.out.println("Введите количество мест в комнате - ");
        room.setRoomPlaces(ScanUtil.getInt());

        System.out.println("Введите цену комнаты - ");
        room.setRoomPrice(ScanUtil.getInt());
        room.setRoomStatus(RoomStatus.EMPTY);
        System.out.println();

        adminController.getAdminController().saveNewRoom(room);
        System.out.println("Комната - \n" + room + " \nсоздана.\n");
    }
}
