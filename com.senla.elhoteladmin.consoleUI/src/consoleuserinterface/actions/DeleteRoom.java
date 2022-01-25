package consoleuserinterface.actions;

import com.senla.elhoteladmin.entity.Room;
import com.senla.elhoteladmin.service.RoomService;
import consoleuserinterface.utils.ScanUtil;

public class DeleteRoom implements IAction {
    private final RoomService roomService = RoomService.getInstance();

    @Override
    public void execute() {
        System.out.println("Введите номер комнаты для удаления - ");
        Room room = roomService.getRoomByNumber(ScanUtil.getInt());
        if (room != null) {
            roomService.deleteRoom(room);
        }
        System.out.println("Комната \n" + room + "\nудалена.\n");
    }
}
