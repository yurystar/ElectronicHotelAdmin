package consoleuserinterface.actions;

import com.senla.elhoteladmin.controller.AdminControllerSingleton;
import consoleuserinterface.utils.ScanUtil;

public class DeleteBookingOrder implements IAction{
    private final AdminControllerSingleton adminControllerSingleton = AdminControllerSingleton.getInstance();

    @Override
    public void execute() {
        System.out.println("Введите номер заказа для удаления - ");
        adminControllerSingleton.deleteBookingOrderByID(ScanUtil.getInt());
        System.out.println("Заказ удален.");
    }
}
