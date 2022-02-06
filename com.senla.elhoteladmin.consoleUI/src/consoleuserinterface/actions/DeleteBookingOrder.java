package consoleuserinterface.actions;

import com.senla.daoservice.controller.ActionController;
import consoleuserinterface.utils.ScanUtil;

public class DeleteBookingOrder implements IAction{
    ActionController adminController = new ActionController();

    @Override
    public void execute() {
        System.out.println("Введите номер заказа для удаления - ");
        adminController.getAdminController().deleteBookingOrderByID(ScanUtil.getInt());
        System.out.println("Заказ удален.");
    }
}
