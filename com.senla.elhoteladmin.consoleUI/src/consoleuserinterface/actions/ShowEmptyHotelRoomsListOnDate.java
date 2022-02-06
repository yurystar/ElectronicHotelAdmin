package consoleuserinterface.actions;

import com.senla.daoservice.controller.ActionController;
import consoleuserinterface.utils.ScanUtil;

public class ShowEmptyHotelRoomsListOnDate implements IAction {
    ActionController adminController = new ActionController();

    @Override
    public void execute() {
        System.out.println("Введите дату для просмотра свободных номеров - ");
        System.out.println(adminController.getAdminController().getEmptyHotelRoomsListOnDate(ScanUtil.getDate()));
        System.out.println();
    }
}
