package consoleuserinterface.actions;

import com.senla.daoservice.controller.ActionController;
import consoleuserinterface.utils.ScanUtil;

public class SetNewPriceRoom implements IAction {
    ActionController adminController = new ActionController();

    @Override
    public void execute() {
        System.out.println("Введите номер комнаты и новую цену- ");
        adminController.getAdminController().setNewPriceRoom(ScanUtil.getInt(), ScanUtil.getInt());
        System.out.println("Новая цена установлена.\n");
    }
}
