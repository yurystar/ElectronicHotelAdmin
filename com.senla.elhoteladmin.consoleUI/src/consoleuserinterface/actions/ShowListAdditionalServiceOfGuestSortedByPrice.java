package consoleuserinterface.actions;

import com.senla.elhoteladmin.service.BookingOrderService;
import consoleuserinterface.utils.ScanUtil;

public class ShowListAdditionalServiceOfGuestSortedByPrice implements IAction {
    private final BookingOrderService bookingOrderService = BookingOrderService.getInstance();

    @Override
    public void execute() {
        System.out.println("Список дополнительных сервисов клиента. \nВведите ID клиента -  " +
                bookingOrderService.getListAdditionalServiceOfGuestSortedByPrice
                        (ScanUtil.getInt()));
        System.out.println();
    }
}
