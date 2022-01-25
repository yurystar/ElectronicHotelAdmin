package consoleuserinterface.actions;

import com.senla.elhoteladmin.controller.AdminControllerSingleton;
import consoleuserinterface.utils.ScanUtil;

public class ShowEmptyHotelRoomsListOnDate implements IAction {
    private final AdminControllerSingleton adminControllerSingleton = AdminControllerSingleton.getInstance();

    @Override
    public void execute() {
        System.out.println("Введите дату для просмотра свободных номеров - ");
        System.out.println(adminControllerSingleton.getEmptyHotelRoomsListOnDate(ScanUtil.getDate()));
        System.out.println();
    }
}
