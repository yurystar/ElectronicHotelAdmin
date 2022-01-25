package consoleuserinterface.actions.exportimportactions;

import consoleuserinterface.actions.IAction;
import consoleuserinterface.utils.CSVWrite;

public class ExportBookingOrder implements IAction {
    @Override
    public void execute() {
        CSVWrite.CSVWriteBookOrder();
    }
}
