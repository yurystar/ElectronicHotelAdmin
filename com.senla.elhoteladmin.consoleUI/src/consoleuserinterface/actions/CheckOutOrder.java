package consoleuserinterface.actions;

import com.senla.daoservice.controller.ActionController;
import consoleuserinterface.utils.ScanUtil;

public class CheckOutOrder implements IAction {
    ActionController adminController = new ActionController();

    @Override
    public void execute() {
        System.out.println("Введите номер заказа - ");
        adminController.getAdminController().checkOutOrder(ScanUtil.getInt());
        System.out.println("Выселение гостей оформлено.\n");
    }
}
