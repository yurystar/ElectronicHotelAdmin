package consoleuserinterface.actions;

import com.senla.daoservice.controller.ActionController;
import com.senla.daoservice.entity.AdditionalService;
import consoleuserinterface.utils.ScanUtil;

public class CreateNewAdditionalService implements IAction {
    ActionController adminController = new ActionController();

    @Override
    public void execute() {
        AdditionalService additionalService = new AdditionalService();

        System.out.println("Введите ID сервиса - ");
        Integer servID = ScanUtil.getInt();
        if (adminController.getAdminController().getAdditionalServiceByID(servID) != null) {
            System.out.println("Комната с таким номером уже существует.\n");
            return;
        } else additionalService.setServiceID(servID);

        System.out.println("Введите название сервиса - ");
        additionalService.setServiceName(ScanUtil.getStr());

        System.out.println("Введите цену сервиса - ");
        additionalService.setServicePrice(ScanUtil.getInt());

        adminController.getAdminController().saveNewAdditionalService(additionalService);
        System.out.println("Дополнительный сервис - \n" + additionalService + " \nсоздан.\n");
    }
}
