package consoleuserinterface.actions;

import com.senla.elhoteladmin.controller.AdminControllerSingleton;
import consoleuserinterface.utils.ScanUtil;

public class ShowRoomDetails implements IAction {
    private final AdminControllerSingleton adminControllerSingleton = AdminControllerSingleton.getInstance();

    @Override
    public void execute() {
        System.out.println("Введите номер комнаты - ");
        Integer roomNum = ScanUtil.getInt();
        if (adminControllerSingleton.getRoomByNum(roomNum) != null) {
            System.out.print("Комната номер - " + roomNum);
            System.out.println(adminControllerSingleton.getRoomByNum(roomNum));
        } else System.out.println("Нет такой комнаты.");
        System.out.println();
    }
}
