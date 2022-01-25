package consoleuserinterface.actions;

import com.senla.elhoteladmin.service.BookingOrderService;
import consoleuserinterface.utils.ScanUtil;

public class ShowLastThreeGuestsRoom implements IAction {
    private final BookingOrderService bookingOrderService = BookingOrderService.getInstance();

    @Override
    public void execute() {
        System.out.println("Введите номер комнаты - \n");
        System.out.println("Список 3-х последних постояльцев комнаты - \n" +
                bookingOrderService.getLastThreeGuestsRoom(ScanUtil.getInt()));
    }
}
