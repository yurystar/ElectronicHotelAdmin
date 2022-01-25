package consoleuserinterface.actions;

import com.senla.elhoteladmin.service.AdditionalServiceService;

public class ShowListAdditionalServices implements IAction{
    private final AdditionalServiceService additionalServiceService =
            AdditionalServiceService.getInstance();

    @Override
    public void execute() {
        System.out.println("Список всех дополнительных сервисов отеля - " +
                additionalServiceService.getListAdditionalServices());
        System.out.println();
    }
}
