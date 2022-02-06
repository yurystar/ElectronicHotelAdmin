package consoleuserinterface.actions;

import com.senla.daoservice.controller.ActionController;
import com.senla.daoservice.entity.AdditionalService;
import consoleuserinterface.utils.ScanUtil;

public class DeleteAdditionalService implements IAction{
    ActionController adminController = new ActionController();

    @Override
    public void execute() {
        System.out.println("Введите номер дополнительного сервиса для удаления - ");
        AdditionalService additionalService =
                adminController.getAdminController().getAdditionalServiceByID(ScanUtil.getInt());
        if (additionalService != null) {
            adminController.getAdminController().deleteAdditionalService(additionalService);
        }
        System.out.println("Дополнительный сервис \n" + additionalService + "\nудален.\n");
    }
}
