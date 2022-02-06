package consoleuserinterface.actions;

import com.senla.daoservice.controller.ActionController;
import consoleuserinterface.utils.ScanUtil;

public class SetRoomStatusAsEmpty implements IAction {
    ActionController adminController = new ActionController();

    @Override
    public void execute() {
        System.out.println("Введите номер комнаты - ");
        adminController.getAdminController().setRoomStatusAsEmpty(ScanUtil.getInt());
        System.out.println("Статус изменен. \n");
        System.out.println();
    }
}
