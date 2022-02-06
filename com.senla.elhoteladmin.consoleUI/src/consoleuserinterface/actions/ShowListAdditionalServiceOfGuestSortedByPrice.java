package consoleuserinterface.actions;

import com.senla.daoservice.controller.ActionController;
import consoleuserinterface.utils.ScanUtil;

public class ShowListAdditionalServiceOfGuestSortedByPrice implements IAction {
    ActionController adminController = new ActionController();

    @Override
    public void execute() {
        System.out.println("Введите ID клиента - ");
        System.out.println("Список дополнительных сервисов клиента -  " +
                adminController.getAdminController()
                        .getListAdditionalServiceOfGuestSortedByPrice(ScanUtil.getInt()));
        System.out.println();
    }
}
