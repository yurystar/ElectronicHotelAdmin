package consoleuserinterface.actions;

import com.senla.elhoteladmin.entity.AdditionalService;
import com.senla.elhoteladmin.service.AdditionalServiceService;
import consoleuserinterface.utils.ScanUtil;

public class CreateNewAdditionalService implements IAction {
    private final AdditionalServiceService service = AdditionalServiceService.getInstance();

    @Override
    public void execute() {
        AdditionalService additionalService = new AdditionalService();

        System.out.println("Введите ID сервиса - ");
        Integer servID = ScanUtil.getInt();
        if (service.getAdditionalServiceByID(servID) != null) {
            System.out.println("Комната с таким номером уже существует.\n");
            return;
        } else additionalService.setServiceID(servID);

        System.out.println("Введите название сервиса - ");
        additionalService.setServiceName(ScanUtil.getStr());

        System.out.println("Введите цену сервиса - ");
        additionalService.setServicePrice(ScanUtil.getInt());

        service.saveNewAdditionalService(additionalService);
        System.out.println("Дополнительный сервис - \n" + additionalService + " \nсоздан.\n");
    }
}
