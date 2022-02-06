package consoleuserinterface.actions.exportimportactions;

import com.senla.daoservice.dao.IBookingOrderRepo;
import consoleuserinterface.actions.IAction;
import consoleuserinterface.utils.CSVRead;

public class ImportBookingOrder implements IAction {
    CSVRead csvRead = new CSVRead();

    @Override
    public void execute() {
        csvRead.CSVReadBookOrder();
    }
}
