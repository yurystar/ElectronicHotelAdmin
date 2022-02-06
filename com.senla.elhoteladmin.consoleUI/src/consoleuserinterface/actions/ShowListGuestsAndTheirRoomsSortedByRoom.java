package consoleuserinterface.actions;

import com.senla.daoservice.controller.ActionController;

public class ShowListGuestsAndTheirRoomsSortedByRoom implements IAction{
    ActionController adminController = new ActionController();

    @Override
    public void execute() {
        System.out.println("Список гостей и их номеров" +
                adminController.getAdminController().getListGuestsAndTheirRoomsSortedByRoom());
    }
}
