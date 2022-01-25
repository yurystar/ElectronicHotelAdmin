package consoleuserinterface.actions;

import com.senla.elhoteladmin.controller.AdminControllerSingleton;
import consoleuserinterface.utils.ScanUtil;

public class CheckInOrder implements IAction {
    private final AdminControllerSingleton adminControllerSingleton = AdminControllerSingleton.getInstance();

    @Override
    public void execute() {
        System.out.println("Введите номер заказа - ");
        adminControllerSingleton.checkInOrder(ScanUtil.getInt());
        System.out.println("Заселение гостей оформлено.\n");
    }
}
