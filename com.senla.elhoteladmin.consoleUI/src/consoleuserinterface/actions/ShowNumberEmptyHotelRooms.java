package consoleuserinterface.actions;

import com.senla.daoservice.controller.ActionController;

public class ShowNumberEmptyHotelRooms implements IAction {
    ActionController adminController = new ActionController();

    @Override
    public void execute() {
        System.out.println("Количество свободных номеров - " +
                adminController.getAdminController().getNumberEmptyHotelRooms());
        System.out.println();
    }
}
