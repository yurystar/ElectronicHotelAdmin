package consoleuserinterface.actions;

import com.senla.daoservice.controller.ActionController;
import com.senla.daoservice.entity.BookingOrder;
import consoleuserinterface.utils.ScanUtil;

import java.util.List;

public class ShowLastThreeGuestsRoom extends ActionController implements IAction {
    ActionController adminController = new ActionController();

    @Override
    public void execute() {
        System.out.println("Введите номер комнаты - ");
        List<BookingOrder> bookingOrders =
                adminController.getAdminController().getLastThreeGuestsRoom(ScanUtil.getInt());
        System.out.println("Список 3-х последних постояльцев комнаты - ");
        for (BookingOrder order : bookingOrders) {
            System.out.println(order.getOrderHotelGuests());
            System.out.println(order.getOrderCheckInDate());
            System.out.println(order.getOrderCheckOutDate());
            System.out.println("==============================================================================");
        }
        System.out.println();
    }
}
