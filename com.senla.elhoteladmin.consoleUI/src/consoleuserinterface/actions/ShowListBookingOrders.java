package consoleuserinterface.actions;

import com.senla.elhoteladmin.entity.BookingOrder;
import com.senla.elhoteladmin.service.BookingOrderService;

public class ShowListBookingOrders implements IAction {
    private final BookingOrderService bookingOrderService = BookingOrderService.getInstance();

    @Override
    public void execute() {
        System.out.println("Список всех заказов - ");
        for (BookingOrder order : bookingOrderService.getListBookingOrders()) {
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println(order);
            System.out.println("---------------------------------------------------------------------------------");
        }
        System.out.println();
    }
}
