package consoleuserinterface.actions;

import com.senla.daoservice.controller.ActionController;

public class ShowGuestsHotel implements IAction {
    ActionController adminController = new ActionController();

    @Override
    public void execute() {
        System.out.println("Список всех гостей - \n" +
                adminController.getAdminController().getGuestsHotel());
        System.out.println();
    }
}
