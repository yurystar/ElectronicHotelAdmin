package consoleuserinterface.actions;

import com.senla.elhoteladmin.controller.AdminControllerSingleton;
import consoleuserinterface.utils.ScanUtil;

public class GetOrderPrice implements IAction {
    private final AdminControllerSingleton adminControllerSingleton = AdminControllerSingleton.getInstance();

    @Override
    public void execute() {
        System.out.println("Введите номер заказа - ");
        Integer choice = ScanUtil.getInt();
        System.out.println("Стоимость проживания по ордеру №" + choice + " - " +
                adminControllerSingleton.getOrderPrice(choice));
        System.out.println();
    }
}
