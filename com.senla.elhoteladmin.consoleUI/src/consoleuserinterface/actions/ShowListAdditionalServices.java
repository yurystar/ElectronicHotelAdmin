package consoleuserinterface.actions;

import com.senla.daoservice.controller.ActionController;

public class ShowListAdditionalServices implements IAction{
    ActionController adminController = new ActionController();

    @Override
    public void execute() {
        System.out.println("Список всех дополнительных сервисов отеля - " +
                adminController.getAdminController().getListAdditionalServices());
        System.out.println();
    }
}
