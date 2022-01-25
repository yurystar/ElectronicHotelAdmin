package consoleuserinterface.actions;

import com.senla.elhoteladmin.controller.AdminControllerSingleton;
import consoleuserinterface.utils.ScanUtil;

public class CheckOutOrder implements IAction {
    private final AdminControllerSingleton adminControllerSingleton = AdminControllerSingleton.getInstance();

    @Override
    public void execute() {
        System.out.println("Введите номер заказа - ");
        adminControllerSingleton.checkOutOrder(ScanUtil.getInt());
        System.out.println("Выселение гостей оформлено.\n");
    }
}
