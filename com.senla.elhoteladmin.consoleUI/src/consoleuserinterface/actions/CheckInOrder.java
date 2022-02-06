package consoleuserinterface.actions;

import com.senla.daoservice.controller.ActionController;
import consoleuserinterface.utils.ScanUtil;

public class CheckInOrder implements IAction {
    ActionController adminController = new ActionController();

    @Override
    public void execute() {
        System.out.println("Введите номер заказа - ");
        adminController.getAdminController().checkInOrder(ScanUtil.getInt());
        System.out.println("Заселение гостей оформлено.\n");
    }
}
