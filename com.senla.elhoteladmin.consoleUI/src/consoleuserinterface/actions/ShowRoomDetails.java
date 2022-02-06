package consoleuserinterface.actions;

import com.senla.daoservice.controller.ActionController;
import consoleuserinterface.utils.ScanUtil;

public class ShowRoomDetails implements IAction {
    ActionController adminController = new ActionController();

    @Override
    public void execute() {
        System.out.println("Введите номер комнаты - ");
        Integer roomNum = ScanUtil.getInt();
        if (adminController.getAdminController().getRoomByNum(roomNum) != null) {
            System.out.print("Комната номер - " + roomNum);
            System.out.println(adminController.getAdminController().getRoomByNum(roomNum));
        } else System.out.println("Нет такой комнаты.");
        System.out.println();
    }
}
