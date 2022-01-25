package consoleuserinterface.actions;

import com.senla.elhoteladmin.entity.AdditionalService;
import com.senla.elhoteladmin.service.AdditionalServiceService;
import consoleuserinterface.utils.ScanUtil;

public class DeleteAdditionalService implements IAction{
    private final AdditionalServiceService service = AdditionalServiceService.getInstance();

    @Override
    public void execute() {
        System.out.println("Введите номер дополнительного сервиса для удаления - ");
        AdditionalService additionalService = service.getAdditionalServiceByID(ScanUtil.getInt());
        if (additionalService != null) {
            service.deleteAdditionalService(additionalService);
        }
        System.out.println("Дополнительный сервис \n" + additionalService + "\nудален.\n");
    }
}
