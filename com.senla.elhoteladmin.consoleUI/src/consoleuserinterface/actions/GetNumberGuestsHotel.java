package consoleuserinterface.actions;

import com.senla.daoservice.controller.ActionController;

public class GetNumberGuestsHotel implements IAction {
    ActionController adminController = new ActionController();

    @Override
    public void execute() {
        System.out.println("Общее количество гостей отеля - " +
                adminController.getAdminController().getNumberGuestsHotel());
        System.out.println();
    }
}
