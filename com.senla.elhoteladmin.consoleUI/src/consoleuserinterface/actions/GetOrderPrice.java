package consoleuserinterface.actions;

import com.senla.daoservice.controller.ActionController;
import consoleuserinterface.utils.ScanUtil;

public class GetOrderPrice implements IAction {
    ActionController adminController = new ActionController();

    @Override
    public void execute() {
        System.out.println("Введите номер заказа - ");
        Integer choice = ScanUtil.getInt();
        System.out.println("Стоимость проживания по ордеру №" + choice + " - " +
                adminController.getAdminController().getOrderPrice(choice));
        System.out.println();
    }
}
