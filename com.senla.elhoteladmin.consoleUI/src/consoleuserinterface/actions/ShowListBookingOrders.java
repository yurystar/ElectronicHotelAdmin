package consoleuserinterface.actions;

import com.senla.daoservice.controller.ActionController;
import com.senla.daoservice.entity.BookingOrder;

public class ShowListBookingOrders implements IAction {
    ActionController adminController = new ActionController();

    @Override
    public void execute() {
        System.out.println("Список всех заказов - ");
        for (BookingOrder order : adminController.getAdminController().getListBookingOrders()) {
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println(order);
            System.out.println("---------------------------------------------------------------------------------");
        }
        System.out.println();
    }
}
