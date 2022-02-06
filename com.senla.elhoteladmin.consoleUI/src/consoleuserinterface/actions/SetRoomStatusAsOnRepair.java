package consoleuserinterface.actions;

import com.senla.daoservice.controller.ActionController;
import consoleuserinterface.utils.ScanUtil;

public class SetRoomStatusAsOnRepair implements IAction{
    ActionController adminController = new ActionController();

    @Override
    public void execute() {
        System.out.println("Введите номер комнаты - ");
        adminController.getAdminController().setRoomStatusAsOnRepair(ScanUtil.getInt());
        System.out.println();
    }
}
