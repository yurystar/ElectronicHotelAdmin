package consoleuserinterface.actions.exportimportactions;

import com.senla.elhoteladmin.dao.IBookingOrderRepo;
import consoleuserinterface.actions.IAction;
import consoleuserinterface.utils.CSVRead;

public class ImportBookingOrder implements IAction {
    @Override
    public void execute() {
        CSVRead.CSVReadBookOrder();
    }
}
