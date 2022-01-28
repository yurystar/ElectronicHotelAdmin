package consoleuserinterface.actions;

import com.senla.elhoteladmin.entity.BookingOrder;
import com.senla.elhoteladmin.service.BookingOrderService;
import consoleuserinterface.utils.ScanUtil;

import java.util.List;

public class ShowLastThreeGuestsRoom implements IAction {
    private final BookingOrderService bookingOrderService = BookingOrderService.getInstance();

    @Override
    public void execute() {
        System.out.println("Введите номер комнаты - ");
        List<BookingOrder> bookingOrders = bookingOrderService.getLastThreeGuestsRoom(ScanUtil.getInt());
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
