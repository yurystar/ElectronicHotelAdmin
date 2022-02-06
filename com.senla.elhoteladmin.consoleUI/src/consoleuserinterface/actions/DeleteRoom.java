package consoleuserinterface.actions;

import com.senla.daoservice.controller.ActionController;
import com.senla.daoservice.entity.Room;
import consoleuserinterface.utils.ScanUtil;

public class DeleteRoom implements IAction {
    ActionController adminController = new ActionController();

    @Override
    public void execute() {
        System.out.println("Введите номер комнаты для удаления - ");
        Room room = adminController.getAdminController().getRoomByNum(ScanUtil.getInt());
        if (room != null) {
            adminController.getAdminController().deleteRoom(room);
        }
        System.out.println("Комната \n" + room + "\nудалена.\n");
    }
}
