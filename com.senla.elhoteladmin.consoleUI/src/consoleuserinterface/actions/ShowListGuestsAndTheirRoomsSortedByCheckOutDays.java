package consoleuserinterface.actions;

import com.senla.daoservice.controller.ActionController;

public class ShowListGuestsAndTheirRoomsSortedByCheckOutDays implements IAction {
    ActionController adminController = new ActionController();

    @Override
    public void execute() {
        System.out.println("Список гостей и их номеров" +
                adminController.getAdminController().getListGuestsAndTheirRoomsSortedByCheckOutDays());
        System.out.println();
    }
}
